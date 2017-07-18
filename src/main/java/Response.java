/**
 * Created by Administrator on 2017/7/18.
 */

import java.io.*;

/**
 * 07-18 16:35
 * 响应类
 * @author xt
 **/
public class Response {

    private OutputStream out;

    private Request request;

    public Response(OutputStream out){
        this.out = out;
    }

    public void setRequest(Request request){
        this.request = request;
    }

    public void sendStaticResponse() throws IOException {
        PrintWriter writer = new PrintWriter(out,true);

        File file = new File(Configuration.WEB_ROOT, request.getUri());
        if(file.exists()){
            FileReader reader = new FileReader(file);
            char[] buf = new char[2046];
            StringBuffer sb = new StringBuffer();
            if (reader.read(buf)>0){
                sb.append(buf);
            }
            reader.close();

            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/html; charset=UTF-8");
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
        out.close();
    }

}
