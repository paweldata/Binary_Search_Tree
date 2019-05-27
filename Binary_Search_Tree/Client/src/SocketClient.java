import java.awt.Container;
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

    public Container sendQuery(ArrayList<String> query) {
        Container answer;

        try {
            out.writeObject(query);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            answer = (Container)in.readObject(); 
            return answer;
        } catch(Exception ex) {
            return null;
        }
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
}
