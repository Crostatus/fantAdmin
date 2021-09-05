package LeagueObjs;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.logging.ConsoleHandler;

public class Members {

    private ArrayList<Member> group;
    private int st_bal;

    public Members(int startingBalance){
        group = new ArrayList<Member>(10);
        st_bal = startingBalance;
    }

    public synchronized void addMember(String memberName, int startingBalance){
        if(League.isEmptyOrNull(memberName) || startingBalance < 30){
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


    private class Member {

        private String name;
        private int balance;

        public Member(String memberName, int startingBalance){
            if(memberName.equals(null) || memberName.equals(""))
                throw new IllegalArgumentException("Pretty bad error: invalid member name");
            if(startingBalance < 25)
                throw new IllegalArgumentException("Pretty bad error: invalid starting balance");

            this.name = memberName;
            this.balance = startingBalance;
        }

    }
}








