package connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ServerSocket Server;
    private Socket Client;

    public SocketServer() {
        try {
            Server = new ServerSocket(4444);
        } catch(IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }

    public void listenSocket() {
        try {
            Client = Server.accept();
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }

    protected void finalize() {
        try {
            Client.close();
            Server.close();
        } catch(IOException ex) {
            System.out.println(ex);
        }
    }
}