package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FootballSimulator {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Thread thread = new Thread();
    private LeagueTable leagueTable;
    public static ArrayList<String> highlights = new ArrayList<>();
    private ArrayList<int[]> matchOrder;
    private int matchTimeSpeed = 1000;
    private int actionAmount = 150;
    private int matchNr;

    public FootballSimulator(){
        leagueTable = PlayerFactory.createLeague();
        matchOrder = leagueTable.createMatchOrder();
        matchNr = 0;
    }

    public void start() throws InterruptedException {

        int userMenuSelectionChoice;
        do {
            System.out.printf(
                    "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                    "[]  F o t b o l l s  S i m u l a t o r n  []\n" +
                    "[]                                        []\n" +
                    "[]  Vänligen välj ett alternativ (0-5):   []\n" +
                    "[]                                        []\n" +
                    "[]     [ 1 ] Spela nästa match            []\n" +
                    "[]     [ 2 ] Se ligatabellen              []\n" +
                    "[]     [ 3 ] Se spelarstatistik           []\n" +
                    "[]     [ 4 ] Se skytteligan               []\n" +
                    "[]     [ 5 ] Inställningar                []\n" +
                    "[]     [ 0 ] Avsluta programmet           []\n" +
                    "[]                                        []\n" +
                    "[][][][][][][][][][][][][][][][][][][][][][]\n");

            do {
                try {
                    userMenuSelectionChoice = Integer.parseInt(scanner.nextLine());
                    if (userMenuSelectionChoice < 0 || userMenuSelectionChoice > 5) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("\nVänligen ange ett giltigt alternativ (0-5) och tryck ENTER!");
                }
            } while (true);

            switch (userMenuSelectionChoice) {
                case 1:
                    if(matchNr < 28) {
                        leagueTable.returnToRightOrder();
                        playMatch(leagueTable.getLeague().get(matchOrder.get(matchNr)[0]), leagueTable.getLeague().get(matchOrder.get(matchNr)[1]));
                        matchNr++;
                    } else {
                        System.out.println("Ligan är färdigspelad! Det finns inga matcher kvar!");
                        break;
                    }
                    if (matchNr == 28){
                        System.out.println("Ligan är färdigspelad för säsongen!");
                        System.out.println("Ligatabellen slutade såhär:\n");
                        showLeagueTable();
                    }
                    break;
                case 2:
                    showLeagueTable();
                    break;
                case 3:
                    showPlayerStats();
                    break;
                case 4:
                    showTopScorers();
                    break;
                case 5:
                    changeSettings();
                    break;
                case 0:
                    return;
            }
            System.out.println("\nTryck på ENTER för att gå vidare...");
            scanner.nextLine();
        } while (true);
    }

    public void playMatch(Team team1, Team team2) throws InterruptedException {
        int gameActions = 1;
        int homeScore = 0;
        int awayScore = 0;
        int goalOrNot;
        team1.getTeam().get(6).setHasTheBall(true);
        team1.setHasPossession(true);

        for (int i = highlights.size()-1; i > 0; i--){
            highlights.remove(highlights.get(i));
        }

        System.out.println("Avspark mellan " + team1 + " och " + team2 + "!\n");

        do {
            if (team1.isHasPossession()) {
                for (Player player : team1.getTeam()) {
                    if (player.isHasTheBall()) {
                        goalOrNot = player.getAction(team1, team2,gameActions);
                        if (goalOrNot == 1) {
                            homeScore++;
                            thread.sleep(2000);
                            System.out.println("Ställningen är " + homeScore + " : " + awayScore);
                            System.out.println(team2.getTeam().get(6) + " tar avsparken!\n");
                        }
                        break;
                    }
                }
            } else if (team2.isHasPossession()) {
                for (Player player : team2.getTeam()) {
                    if (player.isHasTheBall()) {
                        goalOrNot = player.getAction(team2, team1,gameActions);
                        if (goalOrNot == 1) {
                            awayScore++;
                            thread.sleep(2000);
                            System.out.println("Ställningen är " + homeScore + " : " + awayScore);
                            System.out.println(team1.getTeam().get(6) + " tar avsparken!\n");
                        }
                        break;
                    }
                }
            }
            gameActions++;
            thread.sleep(matchTimeSpeed);
        } while (gameActions <= actionAmount);

        System.out.println("Matchen är slut!");
        System.out.println("Resultatet blev " + homeScore + " : " + awayScore+ "\n");

        System.out.println("Matchens höjdpunkter: \n");
        for (int i = 0; i < 3; i++){
            if (highlights.size() > 0) {
                String tempHighlight = highlights.get(random.nextInt(highlights.size()));
                System.out.println(tempHighlight);
                highlights.remove(tempHighlight);
            }
        }

        if (homeScore > awayScore){
            team1.getTeamStats().addWins();
            team1.getTeamStats().addPoints(3);
            team2.getTeamStats().addLosses();
        } else if (homeScore < awayScore){
            team2.getTeamStats().addWins();
            team2.getTeamStats().addPoints(3);
            team1.getTeamStats().addLosses();
        } else if (homeScore == awayScore){
            team1.getTeamStats().addTies();
            team2.getTeamStats().addTies();
            team1.getTeamStats().addPoints(1);
            team2.getTeamStats().addPoints(1);
        }
        team1.getTeamStats().addGoalDifference(homeScore - awayScore);
        team1.getTeamStats().addGoalScored(homeScore);
        team1.getTeamStats().addGoalConceded(awayScore);
        team1.getTeamStats().addPlayedMatches();
        team1.getTeamStats().updateStats();

        team2.getTeamStats().addGoalDifference(awayScore - homeScore);
        team2.getTeamStats().addGoalScored(awayScore);
        team2.getTeamStats().addGoalConceded(homeScore);
        team2.getTeamStats().addPlayedMatches();
        team2.getTeamStats().updateStats();

        for (Player player : team1.getTeam()){
            player.getPlayerStats().updateStats(player);
        }
        for (Player player : team2.getTeam()){
            player.getPlayerStats().updateStats(player);
        }
    }

    private void showLeagueTable() {
        int selection;
        leagueTable.showLeagueTable(1);

        do {
            System.out.println("\nSortera tabellen efter:\n");
            System.out.println("1. Poäng");
            System.out.println("2. Målskillnad");
            System.out.println("3. Gjorda mål");
            System.out.println("4. Insläppta mål");
            System.out.println("5. Vinster");
            System.out.println("6. Förluster");
            System.out.println("7. Oavgjorda");
            System.out.println("8. Spelade matcher");
            System.out.println("\n0. Gå tillbaka");
            do {
                try {
                    selection = Integer.parseInt(scanner.nextLine());
                    if (selection < 0 || selection > 8) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Vänligen ange ett giltigt alternativ!");
                }
            } while (true);

            if (selection == 0) {
                return;
            }

            leagueTable.showLeagueTable(selection);
        }while (true);
    }

    private void showPlayerStats() {
        System.out.printf(
                "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                        "[][][] S P E L A R  S T A T I S T I K [][][]\n");
        System.out.println("Vänligen ange ett alternativ (0-8):\n");
        System.out.println("1. " + leagueTable.getLeague().get(0));
        System.out.println("2. " + leagueTable.getLeague().get(1));
        System.out.println("3. " + leagueTable.getLeague().get(2));
        System.out.println("4. " + leagueTable.getLeague().get(3));
        System.out.println("5. " + leagueTable.getLeague().get(4));
        System.out.println("6. " + leagueTable.getLeague().get(5));
        System.out.println("7. " + leagueTable.getLeague().get(6));
        System.out.println("8. " + leagueTable.getLeague().get(7));
        System.out.println("\n0. Gå tillbaka");

        int selection;
        do {
            try {
                selection = Integer.parseInt(scanner.nextLine());
                if (selection < 0 || selection > 8) {
                    throw new IndexOutOfBoundsException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Vänligen ange ett giltigt alternativ!");
            }
        } while (true);

        switch (selection) {
            case 1:
                for (Player player : leagueTable.getLeague().get(0).getTeam()) {
                    player.printStats();
                }
                break;
            case 2:
                for (Player player : leagueTable.getLeague().get(1).getTeam()) {
                    player.printStats();
                }
                break;
            case 3:
                for (Player player : leagueTable.getLeague().get(2).getTeam()) {
                    player.printStats();
                }
                break;
            case 4:
                for (Player player : leagueTable.getLeague().get(3).getTeam()) {
                    player.printStats();
                }
                break;
            case 5:
                for (Player player : leagueTable.getLeague().get(4).getTeam()) {
                    player.printStats();
                }
                break;
            case 6:
                for (Player player : leagueTable.getLeague().get(5).getTeam()) {
                    player.printStats();
                }
                break;
            case 7:
                for (Player player : leagueTable.getLeague().get(6).getTeam()) {
                    player.printStats();
                }
                break;
            case 8:
                for (Player player : leagueTable.getLeague().get(7).getTeam()) {
                    player.printStats();
                }
                break;
            case 0:
                return;
        }
    }

    public void showTopScorers() {
        ScoringLeague scoringLeague = new ScoringLeague(leagueTable);
        scoringLeague.showTopScorers();
    }

    public void changeSettings() {
        int matchSpeed;
        int actions;
        int selection;

        System.out.println("Vänligen ange ett alternativ (0-2):\n");
        System.out.println("1. Ändra action-hastighet");
        System.out.println("2. Ändra actions per match");
        System.out.println("\n0. Gå tillbaka");
        do {
            try {
                selection = Integer.parseInt(scanner.nextLine());
                if (selection < 0 || selection > 2) {
                    throw new IndexOutOfBoundsException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Vänligen ange ett giltigt alternativ!");
            }
        } while (true);

        switch (selection) {
            case 1:
                System.out.println("Ange önskad action-hastighet i ms (50-3000): ");
                do {
                    try {
                        matchSpeed = Integer.parseInt(scanner.nextLine());
                        if (matchSpeed < 50 || matchSpeed > 3000) {
                            throw new IndexOutOfBoundsException();
                        }
                        this.matchTimeSpeed = matchSpeed;
                        break;
                    } catch (Exception e) {
                        System.out.println("Vänligen ange ett giltigt alternativ!");
                    }
                } while (true);
                changeSettings();
                break;
            case 2:
                System.out.println("Ange önskade antal actions per match (60-200): ");
                do {
                    try {
                        actions = Integer.parseInt(scanner.nextLine());
                        if (actions < 60 || actions > 200) {
                            throw new IndexOutOfBoundsException();
                        }
                        this.actionAmount = actions;
                        break;
                    } catch (Exception e) {
                        System.out.println("Vänligen ange ett giltigt alternativ!");
                    }
                } while (true);
                changeSettings();
                break;
        }
    }
}