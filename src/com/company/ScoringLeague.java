package com.company;

import java.util.ArrayList;

public class ScoringLeague {

    ArrayList<Player> allPlayers = new ArrayList<>();
    ArrayList<Player> topScorers = new ArrayList<>();

    public ScoringLeague(LeagueTable leagueTable){
        getAllPlayers(leagueTable);
    }

    public void showTopScorers(){
        sortByGoals(allPlayers);

        for (Player player : topScorers){
            topScorers.remove(player);
        }
        for (int i = 0; i < 20; i++){
            topScorers.add(allPlayers.get(i));
        }

        System.out.println("Skytteligan:\n");

        int placement = 1;
        for (Player player : topScorers){
            System.out.println(placement + ". " + player.getTeamName() + ", " + player.getName() + ": " + Math.round(player.getPlayerStats().getGoalsScored()));
            placement++;
        }
    }

    public void getAllPlayers(LeagueTable leagueTable){
        for (Team team : leagueTable.getLeague()){
            for (Player player: team.getTeam()){
                allPlayers.add(player);
            }
        }
    }

    public void sortByGoals(ArrayList<Player> list){
        list.sort((Player p1, Player p2) -> {
            if (p1.getPlayerStats().getGoalsScored() > p2.getPlayerStats().getGoalsScored())
                return -1;
            if (p1.getPlayerStats().getGoalsScored() < p2.getPlayerStats().getGoalsScored())
                return 1;
            return 0;
        });
    }
}