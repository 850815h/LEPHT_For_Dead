package com.company;

public class Goalkeeper extends Player{
    private int saving;

    public Goalkeeper(String name, int speed, int dribbling, int passing, int breaking, int saving, String position) {
        super(name, speed, dribbling, passing, breaking, position);
        this.saving = saving;
    }

    public int getSaving() {
        return saving;
    }
}
