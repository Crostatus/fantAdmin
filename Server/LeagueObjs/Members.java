package Server.LeagueObjs;

import Testing.Utilities;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.logging.ConsoleHandler;

public class Members {

    private ArrayList<Member> group;
    private static int st_bal = 500;

    public Members(){
        group = new ArrayList<Member>(10);
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
        group.add(new Member(memberName, startingBalance));
    }

    public static void setStartingBalance(int balance){
        if(balance >= 30)
            st_bal = balance;
    }


    private class Member {

        private String name;
        private int balance;

        public Member(String memberName, int startingBalance){
            if(Utilities.isNullOrEmpty(memberName))
                throw new IllegalArgumentException("Pretty bad error: invalid member name");
            if(startingBalance < 30)
                throw new IllegalArgumentException("Pretty bad error: invalid starting balance");

            this.name = memberName;
            this.balance = startingBalance;
        }

    }
}








