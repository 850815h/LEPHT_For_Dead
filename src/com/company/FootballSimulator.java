package com.company;

import java.util.Scanner;

public class FootballSimulator {

    Scanner scanner = new Scanner(System.in);
    private int actionSpeed = 0;
    Thread thread = new Thread();

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
            }while (true);

            switch(choice){
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

    public void playMatch(){

    }

    public void showLeagueTable(){

    }

    public void showTeamStats(){

    }

    public void showPlayerStats(){

    }

    public void changeSettings(){
        
    }
}