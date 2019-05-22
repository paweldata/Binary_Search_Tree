package connect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SocketClient {
    private Socket Socket;

    private ObjectInputStream in;
    private ObjectOutputStream out;

    public SocketClient() {
        listenSocket();
    }

    public void sendQuery(String info, int value) {

    }

    private void listenSocket() {
        try {
            Socket = new Socket("localhost", 4444);
            out = new ObjectOutputStream(Socket.getOutputStream());
            in = new ObjectInputStream(Socket.getInputStream());
        } catch(IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }

    private ArrayList<String> createArrayList(String info, int value) {
        ArrayList<String> infoList = new ArrayList<>();

        infoList.add(info);

        return infoList;
    }
}