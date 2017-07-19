/**
 * Created by Administrator on 2017/7/18.
 */

import java.util.*;

/**
 * 07-18 16:42
 *
 * @author xt
 **/
public class Configuration {

    public static final String WEB_ROOT = "E:\\IDEAdir\\tommycat\\root";

    public static final int PORT = 9090;

    public static final Set<String> servlets = new HashSet<>();

    static {
        servlets.add("HaloServlet");
    }

    public static final Map<String, String> mimes = new HashMap<>();

    static {
        mimes.put("html", "Content-Type: text/html; charset=UTF-8");
        mimes.put("png", "Content-Type: image/png");
    }

}
