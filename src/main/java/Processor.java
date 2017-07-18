/**
 * Created by Administrator on 2017/7/18.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 07-18 16:11
 *
 * @author xt
 **/
public class Processor {
    private Socket socket;

    public Processor(Socket socket){
        this.socket = socket;
    }

    public void processServlet(){

    }

    public void processStatic() throws IOException {
        Request request = new Request(socket.getInputStream());
        Response response = new Response(socket.getOutputStream());
        response.setRequest(request);
        response.sendStaticResponse();
    }





}
