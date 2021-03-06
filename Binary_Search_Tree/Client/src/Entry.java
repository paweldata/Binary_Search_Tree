import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Entry frame.
 * Asks about type of elements.
 * @author Paweł Data
 */
public class Entry extends JFrame implements ActionListener {
    private JButton integerButton;
    private JButton doubleButton;
    private JButton stringButton;

    /**
     * Class constructor.
     */
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

    /**
     * Runs, when button was clicked.
     * Create main frame.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String type = "";

        if (e.getSource().equals(integerButton)) {
            type = "Integer";
        } else if (e.getSource().equals(doubleButton)) {
            type = "Double";
        } else if (e.getSource().equals(stringButton)) {
            type = "String";
        }

        new mainFrame(type);

        this.dispose();
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        new Entry();
    }
}