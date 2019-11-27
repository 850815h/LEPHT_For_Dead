package com.company;

public class Goalkeeper extends Player{
    private int saving;

    public Goalkeeper(String name, int speed, int dribbling, int passing, int breaking, int saving) {
        super(name, speed, dribbling, passing, breaking);
        this.saving = saving;
    }

    public int getSaving() {
        return saving;
    }
}
