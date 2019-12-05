package com.company;

public class Goalkeeper extends Player{

    public Goalkeeper(String name, int speed, int dribblingAbility, int breakingAbility, int passingAbility, String position, int shootingAbility, String teamName, int savingAbility) {
        super(name, speed, dribblingAbility, breakingAbility, passingAbility, position, shootingAbility, teamName);
        this.savingAbility = savingAbility;
    }

    public int getSavingAbility() {
        return savingAbility;
    }

    @Override
    public int getAction(Team opposingTeam, Team ownTeam, int gameAction) {
        return 0;
    }
}
