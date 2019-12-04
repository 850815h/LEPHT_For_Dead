package com.company;

import java.util.ArrayList;

public class Team {
    /*
    attribut: 11 x Player, namn, goalPlus/minus, losses, wins, ties, points
     */

    private String teamName;
    private int goalPlus;
    private int losses;
    private int wins;
    private int ties;
    private int points;

    //private TeamStats teamStats = new TeamStats();
    private ArrayList<Player> team;
    private TeamStats teamStats = new TeamStats();



    public Team( String teamName, ArrayList<Player> team) {
        this.teamName = teamName;
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public TeamStats getTeamStats() {
        return teamStats;
    }

    public String toString() {
        return teamName;
    }

    public String getName() {
        return teamName;
    }

    public ArrayList<Player> getTeam() {
        return team;
    }


}
