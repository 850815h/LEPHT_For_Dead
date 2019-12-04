package com.company;

import java.util.ArrayList;
import java.util.Random;

public class PlayerFactory {

    static String [] teamNames = {"Gurras Chark Och Ost", "Gränspolisens FF", "Stinas Kök & Hemtjänst", "Travföreningen i Mellerud", "LCHF IF",
            "Entusiastiska Lokföreningen", "Benknäckarna", "Postnords Finest"};
    /*  static ArrayList<Team> teamList = new ArrayList<>();
     */
    static Random random = new Random();
    static String[] firstNames = {"Bamse", "Tomten", "Lennart", "Hassan", "Hulken", "Emanuel", "Leana", "Pontus", "Tobias", "Mimmi", "Fantomen", "Catwoman", "Pluto", "Piff", "Puff", "Kalle", "Musse", "Arya", "Cliff"
            , "Arnold", "Zlatan", "WonderWoman", "Betty Boop", "Khaleesi", "Kingslayer"};

    static String[] lastNames = {"McRib", "Steel", "Targaryan", "Stallone", "Armstrong", "Svensson", "Hussein", "Strong", "Schwarzenegger", "Stålnacke", "af von Knapp", "Terminator", "Jonsson", "BigMac",
            "Maradona", "Köttfärs", "Baba", "Beerpong", "Wordfeud", "Candy Crush", "Messi", "Ronaldo", "Ibrahimovic", "Silverhjelm", "Lingongrova"};

    private static ArrayList<Team> teamList = new ArrayList<>();

    public static String createName() {
        String first = firstNames[random.nextInt(firstNames.length)];
        String last = lastNames[random.nextInt(lastNames.length)];
        String name = first + " " + last;
        return name;
    }

    public static Defender createDefender() {
        int speed = random.nextInt(2) + 1;
        int dribbling = random.nextInt(100);
        int passing = random.nextInt(100);
        int breaking = random.nextInt(100);
        Defender tempDefender = new Defender(createName(), speed, dribbling, passing, breaking);
        return tempDefender;
    }

    public static Midfielder createMidfielder() {
        int speed = random.nextInt(2) + 1;
        int dribbling = random.nextInt(100);
        int passing = random.nextInt(100);
        int breaking = random.nextInt(100);
        Midfielder tempMidfielder = new Midfielder(createName(), speed, dribbling, passing, breaking);
        return tempMidfielder;
    }

    public static Forward createForward() {
        int speed = random.nextInt(2) + 1;
        int dribbling = random.nextInt(100);
        int passing = random.nextInt(100);
        int breaking = random.nextInt(100);
        int shooting = random.nextInt(100);
        Forward tempForward = new Forward(createName(), speed, dribbling, passing, breaking, shooting);
        return tempForward;
    }

    public static ArrayList<Player> createTeam() {
        ArrayList<Player> tempTeam = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            tempTeam.add(createDefender());
        }
        for (int i = 0; i < 4; i++) {
            tempTeam.add(createMidfielder());
        }
        for (int i = 0; i < 2; i++) {
            tempTeam.add(createForward());
        }
        tempTeam.add(new Goalkeeper(createName(), 1, 0, 0, random.nextInt(80), random.nextInt(50) + 50));
        return tempTeam;
    }

    public static LeagueTable createLeague() {
        int teamNr = 0;

        for (int i = 0; i < 8; i++) {
            Team tempTeam = new Team(teamNames[teamNr], createTeam());
            teamList.add(tempTeam);
            teamNr ++;
        }

        return (new LeagueTable(teamList));
    }













}

