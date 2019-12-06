package com.company;

public class Defender extends Player {

    public Defender(String name, int speed, int dribblingAbility, int breakingAbility, int passingAbility, String position, int shootingAbility, String teamName) {
        super(name, speed, dribblingAbility, breakingAbility, passingAbility, position, shootingAbility, teamName);
        originalPosition = 1;
        currentPosition = 1;
    }

    @Override
    public int getAction(Team ownTeam,Team opposingTeam, int gameAction) {
        if (currentPosition == 3){
            if (tryToShoot(ownTeam, opposingTeam, gameAction)) {
                return 1;
            } else return 0;
        }
        int whatToDo = random.nextInt(3);
        if (whatToDo <= 1) {
            tryToPass(ownTeam, opposingTeam);
            return 0;
        } else {
            tryToDribble(ownTeam, opposingTeam, gameAction);
        }
        return 0;
    }
}
