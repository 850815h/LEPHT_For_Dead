package com.company;

import java.util.Random;

public abstract class Player {
    Test
    Random random = new Random();
    private String name;
    protected int currentPosition;
    protected int originalPosition;
    protected boolean hasTheBall = false;
    protected String position;
    private int speed;
    private int passingAbility;
    private int dribblingAbility;
    private int shootingAbility;
    private int breakingAbility;
    protected int savingAbility;
    private PlayerStats playerStats;

    public Player(String name, int savingAbility, int speed, int dribblingAbility, int breakingAbility, int passingAbility, String position, int shootingAbility) {
        this.name = name;
        this.position = position;
        this.speed = speed;
        this.passingAbility = passingAbility;
        this.shootingAbility = shootingAbility;
        this.dribblingAbility = dribblingAbility;
        this.breakingAbility = breakingAbility;
        this.savingAbility = savingAbility;
        this.playerStats = new PlayerStats(this);
    }

    public abstract int getAction(Team opposingTeam, Team ownTeam, int gameAction);

    public void tryToPass(Team ownTeam, Team opposingTeam){
        int attemptedPass = random.nextInt(passingAbility - 19) + 20;
        int passReceiver = random.nextInt(2);
        String oppositePos = "";
        String whoToPass = "";
        Player opposingPlayer = null;
        Player receiver = null;

        switch (position){
            case "LB":
                oppositePos = "RM";
                if (passReceiver == 0) {
                    whoToPass = "LM";
                } else whoToPass = "LCM";
                break;
            case "LCB":
                oppositePos = "RCM";
                if (passReceiver == 0) {
                    whoToPass = "LM";
                } else whoToPass = "LCM";
                break;
            case "RCB":
                oppositePos = "LCM";
                if (passReceiver == 0) {
                    whoToPass = "RM";
                } else whoToPass = "RCM";
                break;
            case "RB":
                oppositePos = "LM";
                if (passReceiver == 0) {
                    whoToPass = "RM";
                } else whoToPass = "RCM";
                break;
            case "LM":
                oppositePos = "RB";
                whoToPass = "LF";
                break;
            case "LCM":
                oppositePos = "RCB";
                if (passReceiver == 0) {
                    whoToPass = "LF";
                } else whoToPass = "RF";
                break;
            case "RCM":
                oppositePos = "LCB";
                if (passReceiver == 0) {
                    whoToPass = "LF";
                } else whoToPass = "RF";
                break;
            case "RM":
                oppositePos = "LB";
                whoToPass = "RF";
                break;
            case "GK":
                int whichFwd = random.nextInt(2);
                passReceiver = random.nextInt(4);
                if (whichFwd == 0){
                    oppositePos = "LF";
                } else oppositePos = "RF";
                if (passReceiver == 0) {
                    whoToPass = "LB";
                } else if (passReceiver == 1){
                    whoToPass = "LCB";
                } else if (passReceiver == 2){
                    whoToPass = "RCB";
                } else if (passReceiver == 3){
                    whoToPass = "RB";
                }
                break;
        }

        for (Player player : opposingTeam.getTeam()){
            if (player.position.equals(oppositePos)){
                opposingPlayer = player;
            }
        }

        if (attemptedPass >= random.nextInt(opposingPlayer.breakingAbility - 19) + 20){
            for (Player player : ownTeam.getTeam()){
                if (player.position.equals(whoToPass)){
                    receiver = player;
                    receiver.hasTheBall = true;
                }
            }
            System.out.println(ownTeam + ": " + this + " lägger en snygg passning till " + receiver + "!\n");
            playerStats.addSuccessfulPass();
        } else {
            opposingPlayer.hasTheBall = true;
            ownTeam.setHasPossession(false);
            opposingTeam.setHasPossession(true);
            System.out.println(ownTeam + ": " + this + " missar passningen och ger bort bollen till " + opposingTeam + ": " + opposingPlayer + "!\n");
            System.out.println(opposingTeam + " har nu bollen!\n");
            opposingPlayer.getPlayerStats().addSuccessfulBreak();
        }
        hasTheBall = false;
        playerStats.addAttemptedPass();
        opposingPlayer.getPlayerStats().addAttemptedBreak();
    }

    public void tryToDribble(Team ownTeam, Team opposingTeam, int gameAction){
        int attemptedDribble = random.nextInt(dribblingAbility - 19) + 20;

        String oppositePos = "";
        Player opposingPlayer = null;

        String highlight;

        switch (position){
            case "LB":
                oppositePos = "RM";
                break;
            case "LCB":
                oppositePos = "RCM";
                break;
            case "RCB":
                oppositePos = "LCM";
                break;
            case "RB":
                oppositePos = "LM";
                break;
            case "LM":
                oppositePos = "RB";
                break;
            case "LCM":
                oppositePos = "RCB";
                break;
            case "RCM":
                oppositePos = "LCB";
                break;
            case "RM":
                oppositePos = "LB";
                break;
        }

        for (Player player : opposingTeam.getTeam()){
            if (player.position.equals(oppositePos)){
                opposingPlayer = player;
            }
        }

        if (attemptedDribble >= random.nextInt(opposingPlayer.breakingAbility - 19) + 20){
            if (speed == 2 && (currentPosition + 2 == 3)){
                currentPosition+=2;
                highlight = "Händelse nr " + gameAction + ", " + ownTeam + ": " + this + " gör en helt otrolig dribbling och springer fram två positioner!\n";
                FootballSimulator.highlights.add(highlight);
                System.out.println(highlight);
            } else {
                currentPosition++;
                System.out.println(ownTeam + ": " + this + " gör en supersnygg dribbling och tar sig förbi " + opposingTeam + ": " + opposingPlayer + "!\n");
            }
            playerStats.addSuccessfulDribble();
        } else {
            hasTheBall = false;
            opposingPlayer.hasTheBall = true;
            ownTeam.setHasPossession(false);
            opposingTeam.setHasPossession(true);
            System.out.println(ownTeam + ": " + this + " dribblar bort sig själv och ger bort bollen till " + opposingTeam + ": " + opposingPlayer + "!\n");
            System.out.println(opposingTeam + " har nu bollen!\n");
            opposingPlayer.getPlayerStats().addSuccessfulBreak();
            currentPosition = originalPosition;
        }
        opposingPlayer.getPlayerStats().addAttemptedBreak();
        playerStats.addAttemptedDribble();
    }

    public boolean tryToShoot(Team ownTeam, Team opposingTeam, int gameAction) {
        int attemptedShot = random.nextInt(shootingAbility - 19) + 20;
        Player opposingPlayer = null;
        boolean goalOrNot = false;
        String highlight;

        for (Player player : opposingTeam.getTeam()){
            if (player.position.equals("GK")){
                opposingPlayer = player;
            }
        }
        if (attemptedShot >= random.nextInt(opposingPlayer.savingAbility - 19) + 20){
            highlight = "Händelse nr " + gameAction + ", " + ownTeam + ": " + this + " gör MÅÅÅÅÅÅÅÅL!!!\n";
            System.out.println(highlight);
            FootballSimulator.highlights.add(highlight);
            playerStats.addGoalsScored();
            goalOrNot = true;
            opposingTeam.getTeam().get(6).hasTheBall = true;
        } else {
            highlight = "Händelse nr " + gameAction + ", " + ownTeam + ": " + this + " skjuter mot mål!! Ett snyggt försök, men målvakten räddar!\n";
            System.out.println(highlight);
            FootballSimulator.highlights.add(highlight);
            System.out.println(opposingTeam + " har nu bollen!\n");
            opposingPlayer.hasTheBall = true;
            opposingPlayer.getPlayerStats().addSuccessfulSave();
        }
        opposingPlayer.getPlayerStats().addAttemptedSave();
        playerStats.addAttemptedShot();
        hasTheBall = false;
        ownTeam.setHasPossession(false);
        opposingTeam.setHasPossession(true);
        currentPosition = originalPosition;
        return goalOrNot;
    }

    public String toString(){
        return position + ": " + name;
    }

    public PlayerStats getPlayerStats(){
        return playerStats;
    }

    public void setHasTheBall(boolean hasTheBall){
        this.hasTheBall = hasTheBall;
    }

}
