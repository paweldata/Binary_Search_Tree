package connect;

import java.io.IOException;
import java.net.Socket;

public class SocketClient {
    private Socket Socket;

    public SocketClient() {
        listenSocket();
    }

    private void listenSocket() {
        try {
            Socket = new Socket("localhost", 4444);
        } catch(IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }
}