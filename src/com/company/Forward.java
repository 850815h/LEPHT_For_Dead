package com.company;

public class Forward extends Player {
    private int shooting;

    public Forward(String name, int speed, int dribbling, int passing, int breaking, int shooting, String position) {
        super(name, speed, dribbling, passing, breaking, position);
        this.shooting = shooting;
    }

    public int getShooting(){
        return shooting;
    }
}
