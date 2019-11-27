package com.company;

public abstract class Player {
    private String name;
    private String position;
    private int speed;
    private int passing;
    private int dribbling;
    private int breaking;

    public Player(String name, int speed, int dribbling, int passing, int breaking){
        this.name = name;
        this.speed = speed;
        this.dribbling = dribbling;
        this.passing = passing;
        this.breaking = breaking;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }
}
