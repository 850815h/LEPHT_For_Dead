package com.company;

public abstract class Player {
    private String name;
    private String position;
    private int speed;
    private int passing;
    private int dribbling;
    private int breaking;
    private int shooting;

    public Player(String name, int speed, int dribbling, int passing, int breaking){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }
}
