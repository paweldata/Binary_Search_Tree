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
            Container outputComponent = new Container();

            if (info.get(0) == "Integer") {

                Tree = new Tree<Integer>();

            } else if (info.get(0) == "Double") {

                Tree = new Tree<Double>();

            } else if (info.get(0) == "String") {

                Tree = new Tree<String>();

            } else if (info.get(0) == "Search") {

                try {
                    Tree.search(info.get(1));
                    JLabel note  = new JLabel(info.get(1) + " exist");
                    outputComponent.add(note);
                } catch (Exception ex) {
                    JLabel note  = new JLabel(info.get(1) + " not exist");
                    outputComponent.add(note);
                }

            } else if (info.get(0) == "Insert") {

                Tree.insert(info.get(1));
                outputComponent = Tree.Draw();

            } else if (info.get(0) == "Delete") {

                if (Tree.delete(info.get(1))) {
                    outputComponent = Tree.Draw();
                } else {
                    JLabel note  = new JLabel(info.get(1) + "not exist");
                    outputComponent = Tree.Draw();
                    outputComponent.add(note);
                }

            } else if (info.get(0) == "Draw") {

                outputComponent = Tree.Draw();

            }

            return outputComponent;

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}