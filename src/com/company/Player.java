package com.company;

import java.util.Random;

public abstract class Player {
    Random random = new Random();
    private String name;
    private String teamName;
    protected int currentPosition;
    protected int originalPosition;
    private boolean hasTheBall = false;
    protected String position;
    private int speed;
    private int passingAbility;
    private int dribblingAbility;
    private int breakingAbility;
    protected int savingAbility;
    private PlayerStats playerStats;

    public Player(String name, String teamName, String position, int speed, int passingAbility, int dribblingAbility, int breakingAbility, int savingAbility) {
        this.name = name;
        this.teamName = teamName;
        this.position = position;
        this.speed = speed;
        this.passingAbility = passingAbility;
        this.dribblingAbility = dribblingAbility;
        this.breakingAbility = breakingAbility;
        this.savingAbility = savingAbility;
        this.playerStats = new PlayerStats(this);
    }

    public abstract int getAction(Team opposingTeam, Team ownTeam, int gameAction);

    public void tryToPass() {

    }

    public void tryToDribble() {

    }

    public void tryToShoot() {

    }
}
