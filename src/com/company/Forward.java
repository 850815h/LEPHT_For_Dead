package com.company;

public class Forward extends Player {
    public Forward(String name, int speed, int dribblingAbility, int breakingAbility, int passingAbility, String position, int shootingAbility, String teamName) {
        super(name, speed, dribblingAbility, breakingAbility, passingAbility, position, shootingAbility, teamName);
        currentPosition = 3;
        originalPosition = 3;
    }

    @Override
    public int getAction(Team ownTeam, Team opposingTeam, int gameAction) {
        if (tryToShoot(ownTeam, opposingTeam, gameAction)) {
            return 1;
        } else return 0;
    }

    @Override
    public int getAction(Team ownTeam, Team opposingTeam, int gameAction) {
        return 0;
    }
}
