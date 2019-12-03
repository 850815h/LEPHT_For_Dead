package com.company;

import java.util.ArrayList;

public class TeamStats {

    public int points;
    public int wins;
    public int losses;
    public int ties;
    public int goalScored;
    public int goalsConceded;
    public int goalDifference;
    public int playedMatches;

    public ArrayList<String> summaryOfLastGamesStats = new ArrayList<>();

    public String pointString;
    public String winString;
    public String lossesString;
    public String tieString;
    public String goalScoredString;
    public String goalConcededString;
    public String goalDifferenceString;
    public String playedMatchesString;

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

    public void addPoints(int points) {
        this.points += points;
    }

    public void addWins() {
        wins ++;
    }

    public void addLosses() {
        losses ++;
    }

    public void addTies() {
        ties ++;
    }

    public void addGoalScored(int goalScored) {
        this.goalScored += goalScored;
    }

    public void addGoalConceded(int goalsConceded) {
        this.goalsConceded += goalsConceded;
    }

    public void addGoalDifference(int goalDifference) {
        this.goalDifference += goalDifference;
    }
}
