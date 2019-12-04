package com.company;

import java.util.ArrayList;

public class TeamStats {
//<<<<<<< Updated upstream

    private int points = 0;
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;
    private int goalScored = 0;
    private int goalsConceded = 0;
    private int goalDifference = 0;
    private int playedMatches = 0;

    private ArrayList<String> summaryOfLastGamesStats = new ArrayList<>();

    private String pointString;
    private String winString;
    private String lossesString;
    private String tieString;
    private String goalScoredString;
    private String goalConcededString;
    private String goalDifferenceString;
    private String playedMatchesString;

    public TeamStats() {
        updateStats();
    }

    public void updateStats() {
        if (summaryOfLastGamesStats.size() > 0) {
            summaryOfLastGamesStats.remove(pointString);
            summaryOfLastGamesStats.remove(winString);
            summaryOfLastGamesStats.remove(lossesString);
            summaryOfLastGamesStats.remove(tieString);
            summaryOfLastGamesStats.remove(goalScoredString);
            summaryOfLastGamesStats.remove(goalConcededString);
            summaryOfLastGamesStats.remove(goalDifferenceString);
            summaryOfLastGamesStats.remove(playedMatchesString);
        }

        playedMatchesString = "Spelade matcher:" + playedMatches + "|";
        winString = "Vunna matcher:" + wins + "|";
        tieString = "Oavgjorda matcher:" + ties + "|";
        lossesString = "Förlorade matcher:" + losses + "|";
        goalScoredString = "Gjorda mål:" + goalScored + "|";
        goalConcededString = "Insläppta mål:" + goalsConceded + "|";
        goalDifferenceString = "+/-:" + goalDifference + "|";
        pointString = "Poäng:" + points + "|";

        summaryOfLastGamesStats.add(playedMatchesString);
        summaryOfLastGamesStats.add(winString);
        summaryOfLastGamesStats.add(tieString);
        summaryOfLastGamesStats.add(lossesString);
        summaryOfLastGamesStats.add(goalScoredString);
        summaryOfLastGamesStats.add(goalConcededString);
        summaryOfLastGamesStats.add(goalDifferenceString);
        summaryOfLastGamesStats.add(pointString);
    }

    @Override
    public String toString() {
        for (String string : summaryOfLastGamesStats) {
            System.out.println(string);
        }
        return "";
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }

    public int getGoalScored() {
        return goalScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getPlayedMatches() {
        return playedMatches;
    }

    public void addPlayedMatches() {
        playedMatches++;
    }

    public void addPoints( int points ) {
        this.points += points;
    }

    public void addWins() {
        wins++;
    }

    public void addLosses() {
        losses++;
    }

    public void addTies() {
        ties++;
    }

    public void addGoalScored( int goalScored ) {
        this.goalScored += goalScored;
    }

    public void addGoalConceded( int goalsConceded ) {
        this.goalsConceded += goalsConceded;
    }

    public void addGoalDifference( int goalDifference ) {
        this.goalDifference += goalDifference;
    }
}
//======= My own class TeamStats
 /*   private int won;
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
>>>>>>> Stashed changes
    }*/
