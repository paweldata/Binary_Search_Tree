import java.awt.Container;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JLabel;

import tree.Tree;

public class Service {
    private Tree Tree;

    public Container analize(ObjectInputStream in) {

        try {
            ArrayList<String> info =  (ArrayList<String>)in.readObject();
            System.out.println(info);
            Container outputComponent = new Container();

            if (info.get(0).equals("Integer")) {

                System.out.println("Tu jestem");
                Tree = new Tree<Integer>();
                return null;

            } else if (info.get(0).equals("Double")) {

                Tree = new Tree<Double>();
                return null;

            } else if (info.get(0).equals("String")) {

                Tree = new Tree<String>();
                return null;

            } else if (info.get(0).equals("Search")) {

                try {
                    Tree.search(info.get(1));
                    JLabel note  = new JLabel(info.get(1) + " exist");
                    outputComponent.add(note);
                } catch (Exception ex) {
                    JLabel note  = new JLabel(info.get(1) + " not exist");
                    outputComponent.add(note);
                }

            } else if (info.get(0).equals("Insert")) {

                Tree.insert(info.get(1));
                outputComponent = Tree.Draw();

            } else if (info.get(0).equals("Delete")) {

                if (Tree.delete(info.get(1))) {
                    outputComponent = Tree.Draw();
                } else {
                    JLabel note  = new JLabel(info.get(1) + "not exist");
                    outputComponent = Tree.Draw();
                    outputComponent.add(note);
                }

            } else if (info.get(0).equals("Draw")) {

                outputComponent = Tree.Draw();

            }

            System.out.println(outputComponent.getComponentCount());
            return outputComponent;

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}