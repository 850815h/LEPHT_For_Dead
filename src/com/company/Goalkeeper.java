package com.company;

public class Goalkeeper extends Player{

    public Goalkeeper(String name, int speed, int dribblingAbility, int breakingAbility, int passingAbility, String position, int shootingAbility, String teamName, int savingAbility) {
        super(name, speed, dribblingAbility, breakingAbility, passingAbility, position, shootingAbility, teamName);
        this.savingAbility = savingAbility;
    }

    @Override
    public int getAction(Team ownTeam, Team opposingTeam, int gameAction) {
        tryToPass(ownTeam, opposingTeam);
        return 0;
    }
}
