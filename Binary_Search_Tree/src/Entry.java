import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import connect.SocketClient;
import connect.SocketServer;

public class Entry extends JFrame implements ActionListener {
    private JButton integerButton;
    private JButton doubleButton;
    private JButton stringButton;

    public Entry() {
        this.setSize(300,200);
        this.setLayout(new GridLayout(2,3));

        this.add(new JLabel());
        this.add(new JLabel("Choose type"));
        this.add(new JLabel());

        integerButton = new JButton("Integer");
        integerButton.addActionListener(this);
        this.add(integerButton);

        doubleButton = new JButton("Double");
        doubleButton.addActionListener(this);
        this.add(doubleButton);

        stringButton = new JButton("String");
        stringButton.addActionListener(this);
        this.add(stringButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //SocketServer server;

        //new SocketClient();

        /*if (e.getSource().equals(integerButton)) {
            server = new SocketServer();
            server.listenSocket();
        } else if (e.getSource().equals(doubleButton)) {
            server = new SocketServer();
            server.listenSocket();
        } else if (e.getSource().equals(stringButton)) {
            server = new SocketServer();
            server.listenSocket();
        }*/

        new mainFrame();

        this.dispose();
    }

    public static void main(String[] args) {
        new Entry();
    }
}