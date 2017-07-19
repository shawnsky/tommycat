/**
 * Created by Administrator on 2017/7/18.
 */

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 07-18 19:07
 * 简单的servlet
 * 编译后拷贝到root文件夹下以供测试
 * @author xt
 **/
public class HaloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html; charset=UTF-8");
        out.println();
        out.println("message from HaloServlet");
        out.flush();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
