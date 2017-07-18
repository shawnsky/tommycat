/**
 * Created by Administrator on 2017/7/18.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 07-18 16:35
 * 请求类
 * @author xt
 **/
public class Request {

    private InputStream in;

    public Request(InputStream in){
        this.in = in;
    }

    private String getFirstLine() throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        char[] buf = new char[1024];
        StringBuilder sb = new StringBuilder();
        if(reader.read(buf)>0){
            sb.append(buf);
        }
        String sbs =  sb.substring(0,sb.indexOf("\n"));
        return sb.substring(0,sb.indexOf("\n"));
    }

    public String getMethod(){
        return "GET";
    }

    public String getUri() throws IOException {
        String line = getFirstLine();
        String[] strings = line.split(" ");
        return strings[1].substring(1);
    }

}
