package Server.LeagueObjs;

import Testing.Utilities;

import java.util.ArrayList;

public class Team {

    private static final int gk = 3;
    private static final int def = 3;
    private static final int mid = 3;
    private static final int strk = 3;

    private ArrayList<Player> goalKeepers;
    private ArrayList<Player> defenders;
    private ArrayList<Player> midfielders;
    private ArrayList<Player> strikers;

    private String teamOwner;

    public Team(String teamOwner){
        if(Utilities.isNullOrEmpty(teamOwner))
            return;

        this.teamOwner = teamOwner;
        goalKeepers = new ArrayList<Player>(gk);
        defenders = new ArrayList<Player>(def);
        midfielders = new ArrayList<Player>(mid);
        strikers = new ArrayList<Player>(strk);

        System.out.println("Squadra di " + teamOwner + " creata correttamente!");
    }

    public String getTeamOwner(){
        return this.getTeamOwner();
    }


    public synchronized void addPlayer(Player newPlayer){
        if(Utilities.isNullOrEmpty(newPlayer.name, newPlayer.role))
            return;

        switch (newPlayer.role){
            case "GK":
                if(goalKeepers.size() < gk){
                    goalKeepers.add(newPlayer);
                } else {
                    System.out.println("Already full of goal keepers!");
                }
                break;
            case "D":
                if(defenders.size() < def){
                    defenders.add(newPlayer);
                } else {
                    System.out.println("Already full of defenders!");
                }
                break;
            case "C":
                if(midfielders.size() < mid){
                    midfielders.add(newPlayer);
                } else {
                    System.out.println("Already full of midfielders!");
                }
                break;
            case "A":
                if(strikers.size() < strk){
                    strikers.add(newPlayer);
                } else {
                    System.out.println("Already full of strikers!");
                }
                break;
            default:
                System.out.println("Invalid player role: " + newPlayer.role);
                break;
        }
    }



}
