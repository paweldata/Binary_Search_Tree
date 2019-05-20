import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connect.SocketClient;
import connect.SocketServer;

public class mainFrame extends JFrame implements ActionListener {
    private SocketClient Client;
    private SocketServer Server;

    private JButton searchButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton drawButton;
    private JTextField text;

    public mainFrame() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addTitle();
        this.addOptions();

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void addTitle() {
        JLabel title = new JLabel("Binary search tree", JLabel.CENTER);
        title.setFont(new Font(Font.SERIF,Font.BOLD,40));
        this.add(title, BorderLayout.NORTH);
    }

    private void addOptions() {
        Container options = new Container();
        options.setLayout(new GridLayout(15,1));

        searchButton = new JButton("search");
        options.add(searchButton);
        insertButton = new JButton("insert");
        options.add(insertButton);
        deleteButton = new JButton("delete");
        options.add(deleteButton);
        drawButton = new JButton("draw");
        options.add(drawButton);

        text = new JTextField();
        options.add(text);

        this.add(options, BorderLayout.EAST);
    }
}