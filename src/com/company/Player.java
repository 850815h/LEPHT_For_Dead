package com.company;

public abstract class Player {
    private String name;
    private String position;
    private int speed;
    private int passing;
    private int dribbling;
    private int breaking;
    private int printStats;

    public Player(String name, int speed, int dribbling, int passing, int breaking){
        this.name = name;
        this.speed = speed;
        this.dribbling = dribbling;
        this.passing = passing;
        this.breaking = breaking;
    }

    public int getPrintStats(){
        return printStats;
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
