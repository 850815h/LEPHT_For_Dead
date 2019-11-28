package com.company;

import java.util.Scanner;

public class FootballSimulator {

    private Scanner scanner = new Scanner(System.in);
    private String menuInput;

    private int actionSpeed = 0;
    Thread thread = new Thread();

    public FootballSimulator() {
        System.out.printf(
                " [][][][][][][][][][][][][][][][][][][][][]\n" +
                        "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                        "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                        " []                                      []\n" +
                        " []           V Ä L K O M M E N          []\n" +
                        " []                T I L L               []\n" +
                        " []                                      []\n" +
                        " [] F o t b o l l s  S i m u l a t o r n []\n" +
                        " []                                      []\n" +
                        " []                                      []\n" +
                        "[][][][][][][][][][][][][][][][][][][][][][]\n");
        start();
    }

    public void start() {
        System.out.printf("[][][][][][][][][][][][][][][][][][][][][][]\n" +
                "[]  F o t b o l l s  S i m u l a t o r n  []\n" +
                "[]                                        []\n" +
                "[]  Vänligen välj ett alternativ (0-7):   []\n" +
                "[]                                        []\n" +
                "[]     [ 1 ] Spela nästa match            []\n" +
                "[]     [ 2 ] Se ligatabellen              []\n" +
                "[]     [ 3 ] Se lagstatistik              []\n" +
                "[]     [ 4 ] Se spelarstatistik           []\n" +
                "[]     [ 5 ] Inställningar                []\n" +
                "[]     [ 6 ] Info. om programmet          []\n" +
                "[]     [ 7 ] Avsluta programmet           []\n" +
                "[]                                        []\n" +
                "[][][][][][][][][][][][][][][][][][][][][][]\n");

        menuInput = scanner.nextLine();

        while (true) {

            switch (menuInput) {
                case "1":
                    playMatch();
                    break;
                case "2":
                    showLeagueTable();
                    break;
                case "3":
                    showTeamStats();
                    break;
                case "4":
                    showPlayerStats();
                    break;
                case "5":
                    changeSettings();
                    break;
                case "6":
                    appInformation();
                    break;
                case "7":
                    exitProgram();
                    break;
                default:
                    start();
                    break;
            }
            break;
        }
    }

    private void playMatch() {

    }

    private void showLeagueTable() {
        System.out.printf(
                "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                        "[][][][][] L I G A   T A B E L L  [][][][][]\n" +
                        "[]                                        []\n");


        //Här skall tabellen skrivas ut

        System.out.printf(
                "[]                                        []\n" +
                        "[]                                        []\n" +
                        "[]     [ 0 ] Huvudmeny                    []\n" +
                        "[]                                        []\n" +
                        "[][][][][][][][][][][][][][][][][][][][][][]\n");

        menuInput = scanner.nextLine();

        switch (menuInput) {
            case "0":
                start();
                break;
            default:
                showLeagueTable();
                break;
        }
    }

    private void showTeamStats() {
        System.out.printf(
                "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                        "[][][][]  L A G S T A T I S T I K   [][][][]\n" +
                        "[]                                        []\n");


        //Här skall tabellen skrivas ut

        System.out.printf(
                "[]                                        []\n" +
                        "[]                                        []\n" +
                        "[]     [ 0 ] Huvudmeny                    []\n" +
                        "[]                                        []\n" +
                        "[][][][][][][][][][][][][][][][][][][][][][]\n");

        menuInput = scanner.nextLine();

        switch (menuInput) {
            case "0":
                start();
                break;
            default:
                showLeagueTable();
                break;
        }
    }

    private void showPlayerStats() {
        System.out.printf(
                "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                        "[][][] S P E L A R  S T A T I S T I K [][][]\n" +
                        "[]                                        []\n");

        //Här skall tabellen skrivas ut, om det finns något att skriva ut/visa

        System.out.printf(
                "[]                                        []\n" +
                        "[]                                        []\n" +
                        "[]     [ 0 ] Huvudmeny                    []\n" +
                        "[]                                        []\n" +
                        "[][][][][][][][][][][][][][][][][][][][][][]\n");

        menuInput = scanner.nextLine();

        switch (menuInput) {
            case "0":
                start();
                break;
            default:
                showPlayerStats();
                break;
        }
    }

    private void changeSettings() {
        System.out.printf(
                "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                        "[][][][] I N S T Ä L L N I N G A R  [][][][]\n" +
                        "[]                                        []\n");


        //Här skall tabellen skrivas ut, om det finns något att skriva ut/visa

        System.out.printf(
                "[]                                        []\n" +
                        "[]                                        []\n" +
                        "[]     [ 1 ] Ändra matchförlopp           []\n" +
                        "[]     [ 2 ] Ändra annat                  []\n" +
                        "[]     [ 3 ] Ändra annatAnnat             []\n" +
                        "[]     [ 0 ] Huvudmeny                    []\n" +
                        "[]                                        []\n" +
                        "[][][][][][][][][][][][][][][][][][][][][][]\n");

        menuInput = scanner.nextLine();

        switch (menuInput) {
            case "0":
                start();
                break;
            default:
                changeSettings();
                break;
        }
    }

    private void appInformation() {
        System.out.printf(
                "[][][][][][][][][][][][][][][][][][][][][][]\n" +
                        "[][][][]   I N F O R M A T I O N    [][][][]\n" +
                        "[]                                        []\n");


        //Här skall tabellen skrivas ut, om det finns något att skriva ut/visa

        System.out.printf(
                "[]                                        []\n" +
                        "[]                 MADE BY                []\n" +
                        "[] Emanuel  Tobbe  Leana  Pontus  Hassan  []\n" +
                        "[]                                        []\n" +
                        "[]     [ 0 ] Huvudmeny                    []\n" +
                        "[]                                        []\n" +
                        "[][][][][][][][][][][][][][][][][][][][][][]\n");

        menuInput = scanner.nextLine();

        switch (menuInput) {
            case "0":
                start();
                break;
            default:
                appInformation();
                break;
        }
    }

    private void exitProgram() {
        System.exit(0);
    }
}







/*
//SPARAR DEN FÖRSTA MENYN HÄR
public void start() throws InterruptedException {

        do {
            System.out.println("Välkommen till FotbollsSimulatorn!\n");
            System.out.println("Vänligen välj ett alternativ (0-6):\n");
            System.out.println("1. Spela nästa match");
            System.out.println("2. Se ligatabellen");
            System.out.println("3. Se lagstatistik");
            System.out.println("4. Se spelarstatistik");
            System.out.println("5. Inställningar");
            System.out.println("0. Avsluta programmet");

            int choice;
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 5) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Vänligen ange ett giltigt alternativ!");
                }
            } while (true);

            switch (choice) {
                case 1:
                    playMatch();
                    break;
                case 2:
                    showLeagueTable();
                    break;
                case 3:
                    showTeamStats();
                    break;
                case 4:
                    showPlayerStats();
                    break;
                case 5:
                    changeSettings();
                    break;
                case 0:
                    break;
            }
        } while (true);
    }
 */