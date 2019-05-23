import java.awt.Container;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JLabel;

import tree.Tree;

public class Service {
    private Tree Tree;
    private String option;
    private String type;

    public Container analize(ObjectInputStream in) {

        try {
            ArrayList<String> info =  (ArrayList<String>)in.readObject();
            System.out.println(info);
            Container outputComponent = new Container();

            option = info.get(0);

            if (Tree == null)
                type = info.get(0);

            if (option.equals("Integer")) {

                Tree = new Tree<Integer>();

                return null;

            } else if (option.equals("Double")) {

                Tree = new Tree<Double>();
                return null;

            } else if (option.equals("String")) {

                Tree = new Tree<String>();
                return null;

            } else if (option.equals("Search")) {

                try {

                    if (type.equals("Integer")) {
                        Tree.search(Integer.parseInt(info.get(1)));
                    } else if (type.equals("Double")) {
                        Tree.search(Double.parseDouble(info.get(1)));
                    } else if (type.equals("String")) {
                        Tree.search(info.get(1));
                    } else {
                        return null;
                    }

                    JLabel note  = new JLabel(info.get(1) + " exist");
                    outputComponent.add(note);
                } catch (Exception ex) {
                    JLabel note  = new JLabel(info.get(1) + " not exist");
                    outputComponent.add(note);
                }

            } else if (option.equals("Insert")) {

                if (type.equals("Integer")) {
                    Tree.insert(Integer.parseInt(info.get(1)));
                } else if (type.equals("Double")) {
                    Tree.insert(Double.parseDouble(info.get(1)));
                } else if (type.equals("String")) {
                    Tree.insert(info.get(1));
                } else {
                    return null;
                }

                outputComponent = Tree.Draw();

            } else if (option.equals("Delete")) {

                if (Tree.delete(info.get(1))) {
                    outputComponent = Tree.Draw();
                } else {
                    JLabel note  = new JLabel(info.get(1) + "not exist");
                    outputComponent = Tree.Draw();
                    outputComponent.add(note);
                }

            } else if (option.equals("Draw")) {

                outputComponent = Tree.Draw();

            }

            System.out.println(outputComponent);
            return outputComponent;

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}