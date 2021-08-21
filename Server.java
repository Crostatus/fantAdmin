import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

    private final String defaultIp = "localhost";
    private final int defaultPort = 8083;
    private final int defaultBacklog = 20;
    private final String defaultContextName = "/env";

    private InetSocketAddress addressToListen;
    private int portToListen = -1;
    private HttpServer _server;
    private ReqHandler reqHandler;
    private ThreadPoolExecutor threadPool;

    //HttpContext represents a mapping between the root URI path of an application to a HttpHandler
    //which is invoked to handle requests destined for that path on the associated HttpServer or HttpsServer.
    //HttpContext instances are created by the create methods in HttpServer and HttpsServer
    private HttpContext context;

    public Server(String ip, int port) throws Exception{
        if(ip.equals(null) || port < 0)
            throw new IllegalArgumentException("Unable to start server: invalid arguments! " + ip + " " + port);
        this.portToListen = port;
        try {
            this.addressToListen = new InetSocketAddress(ip, portToListen);
            this._server = HttpServer.create(addressToListen, defaultBacklog);
        } catch(IOException e){
            e.printStackTrace();
            throw e;
        }
        this.reqHandler = new ReqHandler();
        this.threadPool = new ThreadPoolExecutor(3, 10, 2500, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(15));
    }

    public Server() throws Exception{
        try {
            this.addressToListen = new InetSocketAddress(defaultIp, defaultPort);
            this._server = HttpServer.create(addressToListen, defaultBacklog);
        } catch(IOException e){
            e.printStackTrace();
            throw e;
        }
        this.reqHandler = new ReqHandler();
        this.threadPool = new ThreadPoolExecutor(3, 10, 4000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(15));
    }

    public void startServer(){
        _server.createContext(this.defaultContextName, this.reqHandler);
        _server.setExecutor(threadPool);
        _server.start();
        System.out.println("Server started listening on port " + (this.portToListen > 0 ? this.portToListen : this.defaultPort));
    }

}
