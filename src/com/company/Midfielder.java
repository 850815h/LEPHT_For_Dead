package com.company;

public class Midfielder extends Player {
    public Midfielder(String name, int speed, int dribblingAbility, int breakingAbility, int passingAbility, String position, int shootingAbility, String teamName) {
        super(name, speed, dribblingAbility, breakingAbility, passingAbility, position, shootingAbility, teamName);
        currentPosition = 2;
        originalPosition = 2;
    }
    @Override
    public int getAction(Team ownTeam,Team opposingTeam, int gameAction) {
        if (currentPosition == 3){
            if (tryToShoot(ownTeam, opposingTeam, gameAction)) {
                return 1;
            } else return 0;
        }
        int whatToDo = random.nextInt(2);
        if (whatToDo == 0) {
            tryToPass(ownTeam, opposingTeam);
            return 0;
        } else {
            tryToDribble(ownTeam, opposingTeam, gameAction);
        }
        return 0;
    }
}
