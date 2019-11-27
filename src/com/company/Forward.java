package com.company;

public class Forward extends Player {
    private int shooting;

    public Forward(String name, int speed, int dribbling, int passing, int breaking, int shooting) {
        super(name, speed, dribbling, passing, breaking);
        this.shooting = shooting;
    }
}
