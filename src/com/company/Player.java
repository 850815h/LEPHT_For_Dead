package com.company;

import java.util.Random;

public abstract class Player {

    protected Random random = new Random();
    private String name;
    protected int currentPosition;
    protected int originalPosition;
    private boolean hasTheBall = false;
    protected String position;
    private int speed;
    private int passing;
    private int dribbling;
    private int breaking;
    protected int saving;
    private PlayerStats playerStats;

    public Player(String name, String teamName, String position, int speed, int passing, int dribbling, int breaking, int saving) {
        this.name = name;
        this.position = position;
        this.speed = speed;
        this.passing = passing;
        this.dribbling = dribbling;
        this.breaking = breaking;
        this.saving = saving;
        this.playerStats = new PlayerStats(this);
    }

}
