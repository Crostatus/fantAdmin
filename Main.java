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
        test.startServer();
    }

}
