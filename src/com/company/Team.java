package com.company;

import java.util.ArrayList;

public class Team {

    private String teamName;
    private boolean hasPossession = false;

    private ArrayList<Player> team;
    private TeamStats teamStats = new TeamStats();

    private int startingPlace;

    public int getStartingPlace() {
        return startingPlace;
    }

    public Team(String teamName, ArrayList<Player> team, int startingPlace) {
        this.teamName = teamName;
        this.team = team;
        this.startingPlace = startingPlace;
    }

    public boolean isHasPossession() { return hasPossession; }

    public void setHasPossession(boolean hasPossessionOrNot){
        hasPossession = hasPossessionOrNot;
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
