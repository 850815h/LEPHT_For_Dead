package com.company;

public class Goalkeeper extends Player{
    private int saving;

    public Goalkeeper(String name, int speed, int dribbling, int breaking, int passing, String position, int shooting, String teamName, int saving) {
        super(name, speed, dribbling, breaking, passing, position, shooting, teamName);
        this.saving = saving;
    }


    public int getSaving() {
        return saving;
    }

    @Override
    public int getAction(Team ownTeam, Team opposingTeam, int gameAction) {
        return 0;
    }
}
