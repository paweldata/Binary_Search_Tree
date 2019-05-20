import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        if (e.getSource().equals(integerButton)) {
            
        } else if (e.getSource().equals(doubleButton)) {

        } else if (e.getSource().equals(stringButton)) {

        }
        
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new Entry();
    }
}