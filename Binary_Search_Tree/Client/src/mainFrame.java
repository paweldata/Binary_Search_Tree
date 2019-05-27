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
    private JLabel info;
    private Container tree;

    public mainFrame(String type) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addTitle();
        this.addOptions();

        this.tree = new Container();
        this.add(this.tree, BorderLayout.CENTER);

        this.setVisible(true);

        this.Client = new SocketClient();
        this.setType(type);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> query = new ArrayList<>();

        if (e.getSource().equals(searchButton)) {
            query.add("Search");
        } else if (e.getSource().equals(insertButton)) {
            query.add("Insert");
        } else if (e.getSource().equals(deleteButton)) {
            query.add("Delete");
        } else if (e.getSource().equals(drawButton)) {
            query.add("Draw");
        }

        query.add(this.text.getText());

        try {
            this.remove(tree);
        } catch (NullPointerException ex) {}

        this.tree = Client.sendQuery(query);

        try {
            this.add(tree, BorderLayout.CENTER);
        } catch (NullPointerException ex) {}

        this.validate();
    }

    private void setType(String type) {
        ArrayList<String> query = new ArrayList<>();
        query.add(type);

        this.Client.sendQuery(query);
    }

    private void addTitle() {
        JLabel title = new JLabel("Binary search tree", JLabel.CENTER);
        title.setFont(new Font(Font.SERIF,Font.BOLD,40));
        this.add(title, BorderLayout.NORTH);
    }

    private void addOptions() {
        Container options = new Container();
        options.setLayout(new GridLayout(15,1));

        this.searchButton = new JButton("search");
        this.searchButton.addActionListener(this);
        options.add(this.searchButton);
        this.insertButton = new JButton("insert");
        this.insertButton.addActionListener(this);
        options.add(this.insertButton);
        this.deleteButton = new JButton("delete");
        this.deleteButton.addActionListener(this);
        options.add(this.deleteButton);
        this.drawButton = new JButton("draw");
        this.drawButton.addActionListener(this);
        options.add(this.drawButton);

        this.text = new JTextField();
        options.add(this.text);

        this.info = new JLabel();
        options.add(this.info);

        this.add(options, BorderLayout.EAST);
    }
}