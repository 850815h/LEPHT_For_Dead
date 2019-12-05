package com.company;

public abstract class Player {

    private String name;
    private String teamName;
    protected String position;
    private int speed;
    private int passing;
    private int dribbling;
    private int breaking;
    private int printStats;
    private int shooting;
    private boolean hasTheBall;
    private PlayerStats playerStats;

    public Player(String name, int speed, int dribbling, int breaking, int passing, String position, int shooting, String teamName){
        this.name = name;
        this.speed = speed;
        this.dribbling = dribbling;
        this.breaking = breaking;
        this.passing = passing;
        this.position = position;
        this.shooting = shooting;
        this.teamName = teamName;
        this.playerStats = new PlayerStats(this);
    }

    public abstract int getAction(Team ownTeam, Team opposingTeam, int gameAction);


    public void setHasTheBall( boolean playerHasTheBallOrNot ){
        hasTheBall = playerHasTheBallOrNot;
    }

    public boolean getHasTheBall(){
        return hasTheBall;
    }

    public int getPrintStats(){
        return printStats;
    }

    public PlayerStats getPlayerStats(){
        return playerStats;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPassing() {
        return passing;
    }

    public int getDribbling() {
        return dribbling;
    }

    public int getBreaking() {
        return breaking;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }
}
