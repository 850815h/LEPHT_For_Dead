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

    public FootballSimulator() throws InterruptedException {
        leagueTable = PlayerFactory.createLeague();
        matchOrder = leagueTable.createMatchOrder();
        matchNr = 0;
        //welcomeMessage(0.6); //Welcome-meddelande, so vi kan använda sen när allt är klart!
        start();
    }

    private void start() throws InterruptedException {

        int userMenuSelectionChoise;
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
                    userMenuSelectionChoise = Integer.parseInt(scanner.nextLine());
                    if (userMenuSelectionChoise < 0 || userMenuSelectionChoise > 5) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("\nVänligen ange ett giltigt alternativ (0-5) och tryck ENTER!");
                }
            } while (true);

            switch (userMenuSelectionChoise) {
                case 1:
                    playMatch(leagueTable.getLeague().get(matchOrder.get(matchNr)[0]), leagueTable.getLeague().get(matchOrder.get(matchNr)[1]));
                    matchNr++;
                    if (matchNr == 28){
                        System.out.println("Ligan är färdigspelad för säsongen!");
                        System.out.println("Ligatabellen slutade såhär:\n");
                        showLeagueTable();
                        System.out.println("\nTryck på ENTER för att avsluta FotbollsSimulatorn!");
                        scanner.nextLine();
                        System.exit(0);
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
                    if (player.hasTheBall) {
                        goalOrNot = player.getAction(team1, team2,gameActions);
                        if (goalOrNot == 1) {
                            homeScore++;
                            //thread.sleep(2000);
                            System.out.println("Ställningen är " + homeScore + " : " + awayScore);
                            System.out.println(team2.getTeam().get(6) + " tar avsparken!\n");
                        }
                        break;
                    }
                }
            } else if (team2.isHasPossession()) {
                for (Player player : team2.getTeam()) {
                    if (player.hasTheBall) {
                        goalOrNot = player.getAction(team2, team1,gameActions);
                        if (goalOrNot == 1) {
                            awayScore++;
                            //thread.sleep(2000);
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
    }

    public void showPlayerStats() {
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
                    player.getPrintStats();
                }
                break;
            case 2:
                for (Player player : leagueTable.getLeague().get(1).getTeam()) {
                    player.getPrintStats();
                }
                break;
            case 3:
                for (Player player : leagueTable.getLeague().get(2).getTeam()) {
                    player.getPrintStats();
                }
                break;
            case 4:
                for (Player player : leagueTable.getLeague().get(3).getTeam()) {
                    player.getPrintStats();
                }
                break;
            case 5:
                for (Player player : leagueTable.getLeague().get(4).getTeam()) {
                    player.getPrintStats();
                }
                break;
            case 6:
                for (Player player : leagueTable.getLeague().get(5).getTeam()) {
                    player.getPrintStats();
                }
                break;
            case 7:
                for (Player player : leagueTable.getLeague().get(6).getTeam()) {
                    player.getPrintStats();
                }
                break;
            case 8:
                for (Player player : leagueTable.getLeague().get(7).getTeam()) {
                    player.getPrintStats();
                }
                break;
            case 0:
                return;
        }
    }

    public void changeSettings() {

    }

    public void showTopScorers() {

    }

    private void exitProgram() {
        System.exit(0);
    }

    private void welcomeMessage(double welcomeMessageSpeed) throws InterruptedException {

        String menuString = " [][][][][][][][][][][][][][][][][][][][][] +\n"+
                "[][][][][][][][][][][][][][][][][][][][][][] \n"+
                " []                                      [] \n"+
                " []     V  Ä  L  K  K  O  M  M  E  N     [] \n"+
                " []               T  I  L  L             [] \n"+
                " []                                      [] \n"+
                " [] F o t b o l l s  S i m u l a t o r n [] \n"+
                " []                                      [] \n"+
                " []                                      [] \n"+
                "[][][][][][][][][][][][][][][][][][][][][][]  \n";

        String[] parts = menuString.split("");

        for( int i = 0 ; i < parts.length ; i++) {
            int randomNumber = (int)(Math.random()*parts.length);
            delayTimer(.01);
            System.out.print(parts[randomNumber] );
        }

        delayTimer(1);
        start();
    }

    private void delayTimer(double howManySeconds) {
        double wholeSeconds = howManySeconds * 1000;
        try {
            thread.sleep((long) wholeSeconds);
        } catch (Exception e) {
            System.out.println("TimeLeft");
        }
    }


}