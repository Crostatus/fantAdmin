package Server;

import LeagueObjs.League;
import Server.LeagueObjs.*;

public class Main {

    public static void main(String[] args){
        Server test;
        try {
            test = new Server();
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        //Server created
        //test.startServer();

        LeagueObjs.League testLeague = new League("Legazzo di cane", 500);
        testLeague.addMember("Marco");
        testLeague.addMember("Gianni");
        testLeague.addMember("Franco");
        testLeague.addMember("Nando");
        testLeague.addMember("Marcello");
        System.out.println(testLeague.tryNewTransaction("Marco",120,"Koulibaly", "D"));
        System.out.println(testLeague.tryNewTransaction("Gianni",120,"Koulibaly","D"));


    }

}
