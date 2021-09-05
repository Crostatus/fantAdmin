package Server.LeagueObjs;

import Testing.Utilities;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.ConsoleHandler;

public class Members {

    private ArrayList<Member> group;
    private static int st_bal = 500;

    public Members(){
        group = new ArrayList<Member>(10);
    }

    public String addNewPlayer(String memberName, Player player){
        for(Member m : group)
            if(m.name.equals(memberName)) {
                m.playerTeam.addPlayer(player);
                break;
            }
        return "OK";
    }


    public synchronized void addMember(String memberName, int startingBalance){
        if(Utilities.isNullOrEmpty(memberName) || startingBalance < 30){
            System.out.println("[ERRORE] Parametri non validi!");
            return;
        }

        for(Member m : group)
            if(m.name.equals(memberName)) {
                System.out.println("[ERRORE] Utente " + memberName + " già registrato nella competizione!");
                return;
            }
        group.add(new Member(memberName));
    }

    public static void setStartingBalance(int balance){
        if(balance >= 30)
            st_bal = balance;
    }

    public Vector<Team> shareTeams(){
        Vector<Team> tmp = new Vector<>(10);
        for(Member m : group){
            tmp.add(m.getTeam());
        }
        return tmp;
    }

    private class Member {

        private String name;
        private int balance;
        private Team playerTeam;

        public Member(String memberName){
            if(Utilities.isNullOrEmpty(memberName))
                throw new IllegalArgumentException("Pretty bad error: invalid member name");

            this.name = memberName;
            this.balance = st_bal;
            this.playerTeam = new Team(this.name);
        }

        public Team getTeam(){
            return this.playerTeam;
        }

    }
}








