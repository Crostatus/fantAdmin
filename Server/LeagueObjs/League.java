package LeagueObjs;

import Server.LeagueObjs.Members;
import Server.LeagueObjs.Player;
import Server.LeagueObjs.Team;
import Server.LeagueObjs.Transactions;
import Testing.Utilities;

public class League {

    private int startingAmount;
    private String leagueName;
    private Members group;
    private Transactions board;

    public League(String leagueName, int startingAmount){
        if(Utilities.isNullOrEmpty(leagueName) || startingAmount < 30)
            throw new IllegalArgumentException();
        this.startingAmount = startingAmount;
        this.leagueName = leagueName;
        group = new Members();
        board = new Transactions(leagueName, group.shareTeams());
    }


    public void addMember(String memberName){
        group.addMember(memberName, startingAmount);
    }

    public String tryNewTransaction(String buyer, int amount, String player, String role){
        String res = board.saveTransaction(buyer, amount, player, role);
        if(!res.equals("OK"))
            return res;

        res = group.addNewPlayer(buyer, new Player(player, role));
        if(!res.equals("OK")) {
            board.undoTransaction(buyer, amount, player, role);
            return res;
        }

        return res;
    }



}
