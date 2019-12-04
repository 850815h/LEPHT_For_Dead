package com.company;

import java.util.ArrayList;

public class LeagueTable {

    private  ArrayList<Team> league;

    public LeagueTable(ArrayList<Team> teamList){
        this.league = teamList;
    }



    public ArrayList<int[]> createMatchOrder(){
        return null;
    }

    public ArrayList<Team> getLeague(){
        return league;
    }

}
