package LeagueObjs;

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

    private String teamName;

    public Team(String teamName){
        if(League.isEmptyOrNull(teamName))
            return;

        this.teamName = teamName;
        goalKeepers = new ArrayList<Player>(gk);
        defenders = new ArrayList<Player>(def);
        midfielders = new ArrayList<Player>(mid);
        strikers = new ArrayList<Player>(strk);

        System.out.println("Squadra " + teamName + "creata correttamente!");
    }

    public synchronized void addPlayer(String playerName, String playerRole){
        if(League.isEmptyOrNull(playerName) || League.isEmptyOrNull(playerRole))
            return;

        switch (playerRole){
            case "GK":
                if(goalKeepers.size() < gk){
                    goalKeepers.add(new Player(playerName, playerRole));
                } else {
                    System.out.println("Already full of goal keepers!");
                }
                break;
            case "D":
                if(defenders.size() < def){
                    defenders.add(new Player(playerName, playerRole));
                } else {
                    System.out.println("Already full of defenders!");
                }
                break;
            case "C":
                if(midfielders.size() < mid){
                    midfielders.add(new Player(playerName, playerRole));
                } else {
                    System.out.println("Already full of midfielders!");
                }
                break;
            case "A":
                if(strikers.size() < strk){
                    strikers.add(new Player(playerName, playerRole));
                } else {
                    System.out.println("Already full of strikers!");
                }
                break;
            default:
                System.out.println("Invalid player role: " + playerRole);
                break;
        }
    }




    private class Player{

        public String name;
        public String role;

        public Player(String name, String role){
            this.name = name;
            this.role = role;
        }

    }


}
