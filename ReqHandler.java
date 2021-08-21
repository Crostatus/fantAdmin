import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class ReqHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException{
        String requestParamValue = null;
        if("GET".equals(httpExchange.getRequestMethod())) {
            requestParamValue = handleGetRequest(httpExchange);
        }//else if("POST".equals(httpExchange)) {
           // requestParamValue = handlePostRequest(httpExchange);
        //}
        handleResponse(httpExchange, requestParamValue);
    }

    private String handleGetRequest(HttpExchange httpExchange){
        return httpExchange.getRequestHeaders().toString();
    }

    private void handleResponse(HttpExchange httpExchange, String requestParamValue)  throws IOException {
        InputStream inputStream = httpExchange.getRequestBody();
        httpExchange.getResponseHeaders();
        String test = "maremmacinese";
        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, test.length());
        OutputStream outputStream = httpExchange.getResponseBody();


        outputStream.write(test.getBytes());
        outputStream.flush();
        outputStream.close();

        System.out.println("mandata risposta");
    }

}
