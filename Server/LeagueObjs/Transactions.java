package Server.LeagueObjs;

import Testing.Utilities;

import java.util.Date;
import java.util.Vector;

public class Transactions {

    private String leagueOwner;
    private int tr_num = 0;
    private Vector<Transaction> board;
    private Vector<Team> teams;

    public Transactions(String leagueOwner, Vector<Team> teams){
        if(Utilities.isNullOrEmpty(leagueOwner))
            throw new IllegalArgumentException();

        this.leagueOwner = leagueOwner;
        board = new Vector<>(30);
        this.teams = teams;
    }

    public String saveTransaction(String buyer, int amount, String playerName, String role){
        String res = isDuplicate(playerName, role);
        if(!res.equals("NO"))
            return playerName + " -> " + buyer + " for " + amount + " is invalid: " + res;

        Transaction tr;
        try{
            tr = new Transaction(buyer, amount, playerName, role);
        }
        catch (Exception e){
            e.printStackTrace();
            return "INVALID AMOUNT OR ROLE";
        }
        board.add(tr);

        return "OK";
    }

    private String isDuplicate(String playerName, String role){
        for(Transaction x : board)
            if(x.playerName.equals(playerName) && x.role.equals(role))
                return x.buyer + " already bought " + playerName + " for " + x.amount + " #@" + x.date;

        return "NO";
    }

    public void undoTransaction(String buyer, int amount, String player, String role){
        board.removeIf(x -> x.buyer.equals(buyer) && x.amount == amount && x.playerName.equals(player) && x.role.equals(role));
    }


    private class Transaction {
        private String buyer;
        private int amount;
        private String playerName;
        private String role;
        private String date;

        public Transaction(String buyer, int amount, String playerName, String role) {
            if (!checkTransaction(buyer, amount, playerName, role))
                throw new IllegalArgumentException();

            this.buyer = buyer;
            this.amount = amount;
            this.playerName = playerName;
            this.role = role;
            this.date = Utilities.getCurrentDate();
        }

        private Boolean checkTransaction(String buyer, int amount, String playerName, String role) {
            Boolean validAmount = amount > 0;
            Boolean validNames = !Utilities.isNullOrEmpty(buyer, playerName);
            Boolean validRole = role.equals("A") || role.equals("C") || role.equals("D") || role.equals("P");

            return validAmount && validNames && validRole;
        }
    }

}
