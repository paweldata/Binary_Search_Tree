import java.awt.Container;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ServerSocket Server;
    private Socket Client;

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Service Service;

    public SocketServer() {
        try {
            Server = new ServerSocket(4444);
        } catch(IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        Service = new Service();
		this.listenSocket();
    }

    public void listenSocket() {
        try {
            Client = Server.accept();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        try {
            in = new ObjectInputStream(Client.getInputStream());
            out = new ObjectOutputStream(Client.getOutputStream());

            while(true) {
                Container output = Service.analize(in);
                if (output != null) {
                    out.writeObject(output);
                    out.flush();
                }
            }

        } catch(IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    protected void finalize() {
        try {
            in.close();
            out.close();
            Client.close();
            Server.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer();
    }
}