package com.company;

import java.util.ArrayList;

public class LeagueTable {


    private ArrayList<Team> league;

    public LeagueTable(ArrayList<Team> league){
        this.league = league;
    }

    public ArrayList<int[]> createMatchOrder(){
        int[] match1 = {0,1};
        int[] match2 = {2,3};
        int[] match3 = {4,5};
        int[] match4 = {6,7};
        int[] match5 = {0,2};
        int[] match6 = {1,3};
        int[] match7 = {4,6};
        int[] match8 = {5,7};
        int[] match9 = {0,3};
        int[] match10 = {1,2};
        int[] match11 = {4,7};
        int[] match12 = {5,6};
        int[] match13 = {0,4};
        int[] match14 = {1,5};
        int[] match15 = {2,6};
        int[] match16 = {3,7};
        int[] match17 = {0,5};
        int[] match18 = {1,6};
        int[] match19 = {2,7};
        int[] match20 = {3,4};
        int[] match21 = {0,6};
        int[] match22 = {1,7};
        int[] match23 = {2,4};
        int[] match24 = {3,5};
        int[] match25 = {0,7};
        int[] match26 = {1,4};
        int[] match27 = {2,5};
        int[] match28 = {3,6};

        ArrayList<int[]> matchOrder = new ArrayList<>();
        matchOrder.add(match1);
        matchOrder.add(match2);
        matchOrder.add(match3);
        matchOrder.add(match4);
        matchOrder.add(match5);
        matchOrder.add(match6);
        matchOrder.add(match7);
        matchOrder.add(match8);
        matchOrder.add(match9);
        matchOrder.add(match10);
        matchOrder.add(match11);
        matchOrder.add(match12);
        matchOrder.add(match13);
        matchOrder.add(match14);
        matchOrder.add(match15);
        matchOrder.add(match16);
        matchOrder.add(match17);
        matchOrder.add(match18);
        matchOrder.add(match19);
        matchOrder.add(match20);
        matchOrder.add(match21);
        matchOrder.add(match22);
        matchOrder.add(match23);
        matchOrder.add(match24);
        matchOrder.add(match25);
        matchOrder.add(match26);
        matchOrder.add(match27);
        matchOrder.add(match28);

        return matchOrder;
    }

    public ArrayList<Team> getLeague(){
        return league;
    }

    public void returnToRightOrder() {
        league.sort((Team t1, Team t2) -> {
                    if (t1.getStartingPlace() < t2.getStartingPlace())
                        return -1;
                    else if (t1.getStartingPlace() > t2.getStartingPlace())
                        return 1;
                    return 0;
                }
        );
    }

    public void sortByPoints(){
        league.sort((Team t1, Team t2) -> {
            if (t1.getTeamStats().getPoints() > t2.getTeamStats().getPoints())
                return -1;
            else if (t1.getTeamStats().getPoints() < t2.getTeamStats().getPoints())
                return 1;
            else {
                int goalDif1 = t1.getTeamStats().getGoalDifference();
                int goalDif2 = t2.getTeamStats().getGoalDifference();
                if (goalDif1 > goalDif2)
                    return -1;
                else if (goalDif2 < goalDif1)
                    return 1;
                else return 0;
            }
        });
    }

    public void sortByScoredGoals() {
        league.sort((Team t1, Team t2) -> {
                    if (t1.getTeamStats().getGoalScored() > t2.getTeamStats().getGoalScored())
                        return -1;
                    else if (t1.getTeamStats().getGoalScored() < t2.getTeamStats().getGoalScored())
                        return 1;
                    return 0;
                }
        );
    }

    public void sortByGoalDiff() {
        league.sort((Team t1, Team t2) -> {
                    if (t1.getTeamStats().getGoalDifference() > t2.getTeamStats().getGoalDifference())
                        return -1;
                    else if (t1.getTeamStats().getGoalDifference() < t2.getTeamStats().getGoalDifference())
                        return 1;
                    return 0;
                }
        );
    }

    public void sortByPlayedMatches(){
        league.sort((Team t1, Team t2) -> {
                    if (t1.getTeamStats().getPlayedMatches() > t2.getTeamStats().getPlayedMatches())
                        return -1;
                    else if (t1.getTeamStats().getPlayedMatches() < t2.getTeamStats().getPlayedMatches())
                        return 1;
                    return 0;
                }
        );
    }

    public void sortByGoalsAgainst(){
        league.sort((Team t1, Team t2) -> {
                    if (t1.getTeamStats().getGoalsConceded() > t2.getTeamStats().getGoalsConceded())
                        return -1;
                    else if (t1.getTeamStats().getGoalsConceded() < t2.getTeamStats().getGoalsConceded())
                        return 1;
                    return 0;
                }
        );
    }

    public void sortByWins(){
        league.sort((Team t1, Team t2) -> {
                    if (t1.getTeamStats().getWins() > t2.getTeamStats().getWins())
                        return -1;
                    else if (t1.getTeamStats().getWins() < t2.getTeamStats().getWins())
                        return 1;
                    return 0;
                }
        );
    }

    public void sortByLosses(){
        league.sort((Team t1, Team t2) -> {
                    if (t1.getTeamStats().getLosses() > t2.getTeamStats().getLosses())
                        return -1;
                    else if (t1.getTeamStats().getLosses() < t2.getTeamStats().getLosses())
                        return 1;
                    return 0;
                }
        );
    }

    public void sortByTies(){
        league.sort((Team t1, Team t2) -> {
                    if (t1.getTeamStats().getTies() > t2.getTeamStats().getTies())
                        return -1;
                    else if (t1.getTeamStats().getTies() < t2.getTeamStats().getTies())
                        return 1;
                    return 0;
                }
        );
    }

    public void showLeagueTable(int sortSelection){

        switch (sortSelection){
            case 1:
                sortByPoints();
                break;
            case 2:
                sortByGoalDiff();
                break;
            case 3:
                sortByScoredGoals();
                break;
            case 4:
                sortByGoalsAgainst();
                break;
            case 5:
                sortByWins();
                break;
            case 6:
                sortByLosses();
                break;
            case 7:
                sortByTies();
                break;
            case 8:
                sortByPlayedMatches();
                break;
        }
        int i = 1;
        for (Team team : league){
            String lengthCheck = i + ". " + team.getName() + ": ";
            while (lengthCheck.length() < 40){
                lengthCheck += " ";
            }
            System.out.print(lengthCheck);
            System.out.println(team.getTeamStats());
            i++;
        }
    }
}