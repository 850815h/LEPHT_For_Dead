package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FootballSimulator {

    Scanner scanner = new Scanner(System.in);
    Thread thread = new Thread();
    LeagueTable leagueTable;
    ArrayList<int[]> matchOrder;
    int matchSpeed = 1000;
    int actionAmount = 150;
    public static ArrayList<String> highlights = new ArrayList<>();
    int matchNr;
    Random random = new Random();

    public FootballSimulator(){
        leagueTable = PlayerFactory.createLeague();
        matchOrder = leagueTable.createMatchOrder();
        matchNr = 0;
    }

    public void start() throws InterruptedException {
        int userMenuSelectionChoise;
        do {
            System.out.printf("[][][][][][][][][][][][][][][][][][][][][][]\n" +
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
                    System.out.println("\nVänligen ange ett giltigt alternativ (0-5)!");
                }
            } while (true);

            switch (userMenuSelectionChoise) {
                case 1:
                    playMatch();
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

    private void playMatch() {
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

    public void changeSettings() {

    }

    public void showTopScorers() {

    }

    private void exitProgram() {
        System.exit(0);
    }


}