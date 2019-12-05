package com.company;

public class Defender extends Player {

    public Defender(String name, int speed, int dribbling, int breaking, int passing, String position, int shooting, String teamName) {
        super(name, speed, dribbling, breaking, passing, position, shooting, teamName);
    }

    @Override
    public int getAction(Team ownTeam, Team opposingTeam, int gameAction) {
        return 0;
    }
}
