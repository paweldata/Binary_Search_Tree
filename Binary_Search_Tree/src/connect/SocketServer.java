package connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ServerSocket Serwer;
    private Socket Client;

    public SocketServer() {
        try {
            Serwer = new ServerSocket(1234);
        } catch(IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }

        listenSocket();
    }

    private void listenSocket() {
        try {
            Client = Serwer.accept();
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }
}