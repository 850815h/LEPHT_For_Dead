package com.company;

import java.util.ArrayList;

public class PlayerStats {

    private float goalScored = 0;
    private float sucessfulPasses = 0;
    private float succesfulBreaks = 0;
    private float succesfulSaves = 0;
    private float successfullDribble = 0;
    private float attemptedShots = 0;
    private float attemptedPasses = 0;
    private float attemptedBreaks = 0;
    private float attemptedSaves = 0;
    private float attemptedDribbles = 0;

    private float passPercent = 0;
    private float breakPercent = 0;
    private float dribblePercent = 0;
    private float shotPercent = 0;
    private float savePercent = 0;

    private String goalString;
    private String successPass;
    private String successBreak;
    private String successDribble;
    private String shots;
    private String successShots;
    private String successSaves;

    private ArrayList<String> summaryPercentage = new ArrayList<>();
    Player player;

    public PlayerStats(Player player) {
        this.player = player;
        updateStats(player);
    }

    private void getStats() {
        if (attemptedPasses > 0) passPercent = (sucessfulPasses / attemptedPasses) * 100;
        if (attemptedBreaks > 0) breakPercent = (succesfulBreaks / attemptedBreaks) * 100;
        if (attemptedDribbles > 0) dribblePercent = (successfullDribble / attemptedDribbles) * 100;
        if (attemptedShots > 0) shotPercent = (goalScored / attemptedShots) * 100;
        if (attemptedSaves > 0) savePercent = (succesfulSaves / attemptedSaves) * 100;
    }

    public void updateStats(Player player) {
        if (summaryPercentage.size() > 0) {
            summaryPercentage.remove(goalString);
            summaryPercentage.remove(shots);
            summaryPercentage.remove(successShots);
            summaryPercentage.remove(successPass);
            summaryPercentage.remove(successBreak);
            summaryPercentage.remove(successDribble);
            if (player.position.equals("GK")) {
                summaryPercentage.remove(successSaves);
            }
        }

        getStats();

        goalString = "Mål: " + Math.round(goalScored) + " | ";
        successPass = "Passningar: " + Math.round(passPercent) + "% | ";
        successBreak = "Brytningar: " + Math.round(breakPercent) + "% | ";
        successDribble = "Dribblingar: " + Math.round(dribblePercent) + "% | ";
        shots = "Skott: " + Math.round(attemptedShots) + " | ";
        successShots = "Mål/Skott: " + Math.round(shotPercent) + "% | ";
        successSaves = "Räddningar: " + Math.round(savePercent) + "% | ";

        summaryPercentage.add(goalString);
        summaryPercentage.add(shots);
        summaryPercentage.add(successShots);
        summaryPercentage.add(successPass);
        summaryPercentage.add(successBreak);
        summaryPercentage.add(successDribble);
        if (player.position.equals("GK")) {
            summaryPercentage.add(successSaves);
        }
    }

    public String toString() {
        for (String string : summaryPercentage) {
            System.out.println(string);
        }
        return "";
    }
    public float getGoalScored() {
        return goalScored;
    }
    public void addSuccessfulDribble() {
        successfullDribble++;
    }
    public void addAttemptedDribble() {
        attemptedDribbles++;
    }
    public void addGoalsScored() {
        goalScored++;
    }
    public void addSuccessfulPass() {
        sucessfulPasses++;
    }
    public void addSuccessfulBreak() {
        succesfulBreaks++;
    }
    public void addSuccessfulSave() {
        succesfulSaves++;
    }
    public void addAttemptedShot() {
        attemptedShots++;
    }
    public void addAttemptedPass() {
        attemptedPasses++;
    }
    public void addAttemptedBreak() {
        attemptedBreaks++;
    }
    public void addAttemptedSave() {
        attemptedSaves++;
    }
}