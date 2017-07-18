/**
 * Created by Administrator on 2017/7/18.
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 07-18 16:03
 *
 * @author xt
 **/
public class Connector implements Runnable{
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(Configuration.PORT,1,InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                Processor processor = new Processor(socket);
                processor.processStatic();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }
}
