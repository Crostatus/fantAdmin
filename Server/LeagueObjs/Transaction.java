package Server.LeagueObjs;

import Testing.Utilities;

import java.util.Date;

public class Transaction {

    private String buyer;
    private int amount;
    private String playerName;
    private String role;
    private Date date;

    public Transaction(String buyer, int amount, String playerName, String role){
        if(!checkTransactions(buyer, amount, playerName, role))
            throw new IllegalArgumentException();

        this.buyer = buyer;
        this.amount = amount;
        this.playerName = playerName;
        this.role = role;
        this.date = new Date();
    }

    private Boolean checkTransactions(String buyer, int amount, String playerName, String role){
        Boolean validAmount = amount > 0;
        Boolean validNames = !Utilities.isNullOrEmpty(buyer, playerName);
        Boolean validRole = role.equals("A") || role.equals("C") || role.equals("D") || role.equals("P");

        return validAmount && validNames && validRole;
    }

}
