/**
 * Created by Administrator on 2017/7/19.
 */

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * 07-19 11:39
 *
 * @author xt
 **/
public class ServletProcessor {

    private Request request;
    private Response response;
    private String uri;

    public ServletProcessor(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void process() throws IOException {

        //load servlet class
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Configuration.WEB_ROOT);
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        }
        catch (IOException e) {
            System.out.println(e.toString() );
        }
        Class myClass = null;
        try {
            myClass = loader.loadClass(uri);
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }

        Servlet servlet = null;


        //invoke service
        try {
            servlet = (Servlet) myClass.newInstance();
            servlet.service((ServletRequest) request, (ServletResponse) response);
        } catch (Throwable e) {
            System.out.println(e.toString());
        }


    }
}
