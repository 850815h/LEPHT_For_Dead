package com.company;

import java.util.ArrayList;
import java.util.Random;

public class PlayerFactory {

    static String [] teamNames = {"Gurras Chark Och Ost", "Gränspolisens FF", "Stinas Kök & Hemtjänst", "Travföreningen i Mellerud", "LCHF IF",
            "Entusiastiska Lokföreningen", "Benknäckarna", "Postnords Finest"};
    static Random random = new Random();
    static String[] firstNames = {"Bamse", "Tomten", "Lennart", "Hassan", "Hulken", "Emanuel", "Leana", "Pontus", "Tobias", "Mimmi", "Fantomen", "Catwoman", "Pluto", "Piff", "Puff", "Kalle", "Musse", "Arya", "Cliff"
            , "Arnold", "Zlatan", "WonderWoman", "Betty Boop", "Khaleesi", "Kingslayer"};
    static String[] lastNames = {"McRib", "Steel", "Targaryan", "Stallone", "Armstrong", "Svensson", "Hussein", "Strong", "Schwarzenegger", "Stålnacke", "af von Knapp", "Terminator", "Jonsson", "BigMac",
            "Maradona", "Köttfärs", "Baba", "Beerpong", "Wordfeud", "Candy Crush", "Messi", "Ronaldo", "Ibrahimovic", "Silverhjelm", "Lingongrova"};
    private static String[] playerPositions = {"LB", "LCB", "RCB", "RB", "LM", "LCM", "RCM", "RM", "LF", "RF"};
    private static ArrayList<Team> teamList = new ArrayList<>();

    public static String createName() {
        String first = firstNames[random.nextInt(firstNames.length)];
        String last = lastNames[random.nextInt(lastNames.length)];
        String name = first + " " + last;
        return name;
    }

    public static Defender createDefender(String playerPosition, String teamName) {
        int speed = random.nextInt(2) + 1;
        int dribbling = random.nextInt(100);
        int passing = random.nextInt(100);
        int breaking = random.nextInt(100);
        int shooting = random.nextInt(30) + 20;
        Defender tempDefender = new Defender(createName(), speed, dribbling, breaking, passing, playerPosition, shooting, teamName);
        return tempDefender;
    }

    public static Midfielder createMidfielder(String playerPosition, String teamName){
        int speed = random.nextInt(2) + 1;
        int dribbling = random.nextInt(80) + 20;
        int passing = random.nextInt(80) + 20;
        int breaking = random.nextInt(30) + 20;
        int shooting = random.nextInt(60) + 20;
        Midfielder tempMid = new Midfielder(createName(), speed, dribbling, breaking, passing, playerPosition, shooting, teamName);
        return tempMid;
    }

    public static Forward createForward(String playerPosition, String teamName){
        int speed = random.nextInt(2) + 1;
        int dribbling = random.nextInt(50) + 20;
        int passing = random.nextInt(30) + 20;
        int breaking = random.nextInt(10) + 20;
        int shooting = random.nextInt(40) + 60;
        Forward tempForward = new Forward(createName(), speed, dribbling, breaking, passing, playerPosition, shooting, teamName);
        return tempForward;
    }

    public static ArrayList<Player> createTeam(String teamName){
        ArrayList<Player> tempTeam = new ArrayList<>();
        int posNr = 0;
        tempTeam.add(new Goalkeeper(createName(), 1, 0,0, random.nextInt(30) + 70, "GK",0, teamName,random.nextInt(40) + 60));

        for (int i = 0; i < 4; i++){
            tempTeam.add(createDefender(playerPositions[posNr], teamName));
            posNr++;
        }
        for (int i = 0; i < 4; i++){
            tempTeam.add(createMidfielder(playerPositions[posNr], teamName));
            posNr++;
        }
        for (int i = 0; i < 2; i++){
            tempTeam.add(createForward(playerPositions[posNr], teamName));
            posNr++;
        }

        return tempTeam;
    }

    public static LeagueTable createLeague(){
        int teamNr = 0;
        for (int i = 0; i < 8; i++){
            Team tempTeam = new Team(teamNames[teamNr], createTeam(teamNames[teamNr]));
            teamList.add(tempTeam);
            teamNr++;
        }

        LeagueTable leagueTable = new LeagueTable(teamList);
        return leagueTable;
    }













}

