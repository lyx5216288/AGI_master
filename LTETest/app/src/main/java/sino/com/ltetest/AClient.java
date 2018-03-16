package sino.com.ltetest;

import android.provider.SyncStateContract;

import net.sqlcipher.database.SqliteWrapper;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Handler;

/**
 * Created by 刘洋旭 on 2016/7/22.
 */
public class AClient extends Thread {

    private Socket dataSocket;
    private Socket messageSocket;
    private Handler outHandler;
    private Handler inHandler;
    private OutputStream out;
    private String IP;
    private int messagePort=3333;
    private int dataPort=4444;

    private static final int TIME_OUT = 5000;
    private static final String TAG = "TCPClient";

    @Override
    public void run() {
        super.run();
        if (messageSocket == null) {
            InetSocketAddress address = new InetSocketAddress(IP, messagePort);
            messageSocket = new Socket();
            try {
                messageSocket.connect(address, TIME_OUT);
                out = messageSocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (dataSocket == null) {
            InetSocketAddress address = new InetSocketAddress(IP, dataPort);
            dataSocket = new Socket();
            try {
                dataSocket.connect(address, TIME_OUT);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
