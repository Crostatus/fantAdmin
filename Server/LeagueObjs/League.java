package LeagueObjs;

public class League {

    private int startingAmount;
    private String leagueName;
    private Members group;

    public League(String leagueName, int startingAmount){
        if(leagueName.equals(null) || leagueName.equals("") || startingAmount < 30)
            throw new IllegalArgumentException();

        this.startingAmount = startingAmount;
        this.leagueName = leagueName;
        group = new Members(startingAmount);
    }

    public static Boolean isEmptyOrNull(String cmp){
        return cmp.equals(null) || cmp.equals("");
    }

    public void addMember(String memberName){
        group.addMember(memberName, startingAmount);
    }


}
