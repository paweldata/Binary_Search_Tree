import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class mainFrame extends JFrame implements ActionListener {
    private SocketClient Client;

    private JButton searchButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton drawButton;
    private JTextField text;

    public mainFrame(String type) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addTitle();
        this.addOptions();

        this.setVisible(true);

        Client = new SocketClient();
        setType(type);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> query = new ArrayList<>();
        int number;

        try {
            number = Integer.parseInt(this.text.getText());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return;
        }

        if (e.getSource().equals(searchButton)) {
            query.add("Search");
            query.add(number + "");
        } else if (e.getSource().equals(insertButton)) {
            query.add("Insert");
            query.add(number + "");
        } else if (e.getSource().equals(deleteButton)) {
            query.add("Delete");
            query.add(number + "");
        } else if (e.getSource().equals(drawButton)) {
            query.add("Draw");
        }

        Container tree = Client.sendQuery(query);
        this.add(tree, BorderLayout.CENTER);
    }

    private void setType(String type) {
        ArrayList<String> query = new ArrayList<>();
        query.add(type);

        Client.sendQuery(query);
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
        searchButton.addActionListener(this);
        options.add(searchButton);
        insertButton = new JButton("insert");
        insertButton.addActionListener(this);
        options.add(insertButton);
        deleteButton = new JButton("delete");
        deleteButton.addActionListener(this);
        options.add(deleteButton);
        drawButton = new JButton("draw");
        drawButton.addActionListener(this);
        options.add(drawButton);

        text = new JTextField();
        options.add(text);

        this.add(options, BorderLayout.EAST);
    }
}