/**
 * Created by Administrator on 2017/7/18.
 */

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.logging.Logger;

/**
 * 07-18 16:11
 *
 * @author xt
 **/
public class Processor {
    private Socket socket;
    private Request request;
    private Response response;

    public Processor(Socket socket){
        this.socket = socket;
    }

    public void process() throws IOException {
        request = new Request(socket.getInputStream());
        response = new Response(socket.getOutputStream());
        String uri = request.getUri();
        System.out.println("uri: "+uri);
        if(Configuration.servlets.contains(uri)){
            System.out.println("contains");
            ServletProcessor dp = new ServletProcessor(request,response);
            dp.setUri(uri);
            dp.process();
        } else {
            StaticProcessor sp = new StaticProcessor(request, response);
            sp.setUri(uri);
            sp.process();
        }

    }


}
