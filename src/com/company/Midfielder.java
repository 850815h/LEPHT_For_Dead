package com.company;

public class Midfielder extends Player {

    public Midfielder(String name, String teamName, int speed, int dribblingAbility, int passingAbility, int breakingAbility, String position) {
        super(name, speed, dribblingAbility, breakingAbility, passingAbility, position, shootingAbility, teamName);
        originalPosition = 2;
        currentPosition = 2;
    }

    @Override
    public int getAction(Team ownTeam,Team opposingTeam, int gameAction) {
        if (currentPosition == 3){
            if (tryToShoot(ownTeam, opposingTeam, gameAction)) {
                return 1;
            } else return 0;
        }
        int whatToDo = random.nextInt(2);
        if (whatToDo <= 0) {
            tryToPass(ownTeam, opposingTeam);
            return 0;
        } else {
            tryToDribble(ownTeam, opposingTeam, gameAction);
        }
        return 0;
    }
}
