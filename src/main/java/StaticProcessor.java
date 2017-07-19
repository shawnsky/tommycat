/**
 * Created by Administrator on 2017/7/19.
 */

import java.io.*;
import java.net.Socket;

/**
 * 07-19 11:39
 *
 * @author xt
 **/
public class StaticProcessor {

    private Request request;
    private Response response;
    private String uri;

    public StaticProcessor(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void process() throws IOException {
        sendStaticResponse();
    }

    private void sendStaticResponse() throws IOException {
        PrintWriter writer = response.getWriter();
        File file = new File(Configuration.WEB_ROOT, uri);
        if(file.exists()){
            FileReader reader = new FileReader(file);
            char[] buf = new char[2046];
            StringBuffer sb = new StringBuffer();
            if (reader.read(buf)>0){
                sb.append(buf);
            }
            reader.close();

            writer.println("HTTP/1.1 200 OK");
//            writer.println("Content-Type: text/html; charset=UTF-8");
            String suffix = uri.substring(uri.indexOf(".")+1);
            writer.println(Configuration.mimes.get(suffix));
            writer.println();
            writer.println(sb.toString());



        } else {
            String error = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
            writer.println(error);
        }

        writer.close();
    }
}
