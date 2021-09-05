package LeagueObjs;

import Server.LeagueObjs.Members;
import Testing.Utilities;

public class League {

    private int startingAmount;
    private String leagueName;
    private Members group;

    public League(String leagueName, int startingAmount){
        if(Utilities.isNullOrEmpty(leagueName) || startingAmount < 30)
            throw new IllegalArgumentException();
        this.startingAmount = startingAmount;
        this.leagueName = leagueName;
        group = new Members();
    }


    public void addMember(String memberName){
        group.addMember(memberName, startingAmount);
    }


}
