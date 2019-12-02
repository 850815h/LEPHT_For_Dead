package com.company;

public class ClubStats {
    private int won;
    private int tie;
    private int lost;
    private int scoredGoals;
    private int receivedGoals;
    private int matchesPlayed;
    private int points;

    public int getWon() {

        return won;
    }

    public int getTie() {
        return tie;
    }

    public int getLost() {

        return lost;
    }

    public int getScoredGoals() {

        return scoredGoals;
    }

    public int getReceivedGoals() {
        return receivedGoals;
    }

    public int getMatchesPlayed() {

        return matchesPlayed;
    }

    public int getPoints() {

        return points;
    }

    public void setWon(int won) {

        this.won = won;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public void setLost(int lost) {

        this.lost = lost;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public void setReceivedGoals(int receivedGoals) {
        this.receivedGoals = receivedGoals;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
