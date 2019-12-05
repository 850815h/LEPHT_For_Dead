package com.company;

public class Forward extends Player {
    private int shooting;

    public Forward(String name, int speed, int dribbling, int breaking, int passing, String position, int shooting, String teamName) {
        super(name, speed, dribbling, breaking, passing, position, shooting, teamName);
    }


    public int getShooting(){
        return shooting;
    }

    @Override
    public int getAction(Team ownTeam, Team opposingTeam, int gameAction) {
        return 0;
    }
}
