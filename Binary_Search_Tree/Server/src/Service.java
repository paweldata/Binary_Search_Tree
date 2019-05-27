import java.awt.Container;
import java.awt.GridLayout;
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
            Container outputComponent = new Container();

            this.option = info.get(0);

            if (this.Tree == null)
                this.type = info.get(0);

            if (this.option.equals("Integer")) {

                this.Tree = new Tree<Integer>();

                return null;

            } else if (this.option.equals("Double")) {

                this.Tree = new Tree<Double>();
                return null;

            } else if (this.option.equals("String")) {

                this.Tree = new Tree<String>();
                return null;

            } else if (this.option.equals("Search")) {

                try {

                    if (this.type.equals("Integer")) {
                        this.Tree.search(Integer.parseInt(info.get(1)));
                    } else if (this.type.equals("Double")) {
                        this.Tree.search(Double.parseDouble(info.get(1)));
                    } else if (this.type.equals("String")) {
                        this.Tree.search(info.get(1));
                    } else {
                        return null;
                    }

                    JLabel note  = new JLabel(info.get(1) + " exist");
                    outputComponent.setLayout(new GridLayout(12, 1));
                    outputComponent.add(note);

                } catch (Exception ex) {

                    JLabel note  = new JLabel(info.get(1) + " not exist");
                    outputComponent.setLayout(new GridLayout(12, 1));
                    outputComponent.add(note);

                }

            } else if (this.option.equals("Insert")) {

                try {

                    if (this.type.equals("Integer")) {
                        this.Tree.insert(Integer.parseInt(info.get(1)));
                    } else if (this.type.equals("Double")) {
                        this.Tree.insert(Double.parseDouble(info.get(1)));
                    } else if (this.type.equals("String")) {
                        this.Tree.insert(info.get(1));
                    } else {
                        return null;
                    }

                    outputComponent = this.Tree.Draw();
                    
                } catch (NumberFormatException ex) {

                    JLabel note  = new JLabel(info.get(1) + "  : wrong element");
                    outputComponent = this.Tree.Draw();
                    outputComponent.add(note);

                }

            } else if (this.option.equals("Delete")) {

                try {

                    if (this.type.equals("Integer")) {
                        if (this.Tree.delete(Integer.parseInt(info.get(1)))) {
                            outputComponent = this.Tree.Draw();
                        } else {
                            JLabel note  = new JLabel(info.get(1) + "not exist");
                            outputComponent = this.Tree.Draw();
                            outputComponent.add(note);
                        }
                    } else if (this.type.equals("Double")) {
                        if (this.Tree.delete(Double.parseDouble(info.get(1)))) {
                            outputComponent = this.Tree.Draw();
                        } else {
                            JLabel note  = new JLabel(info.get(1) + "not exist");
                            outputComponent = this.Tree.Draw();
                            outputComponent.add(note);
                        }
                    } else if (this.type.equals("String")) {
                        if (this.Tree.delete(info.get(1))) {
                            outputComponent = this.Tree.Draw();
                        } else {
                            JLabel note  = new JLabel(info.get(1) + "not exist");
                            outputComponent = this.Tree.Draw();
                            outputComponent.add(note);
                        }
                    }

                } catch (Exception ex) {

                    JLabel note  = new JLabel(info.get(1) + "  : wrong element");
                    outputComponent = this.Tree.Draw();
                    outputComponent.add(note);
                    
                }

            } else if (this.option.equals("Draw")) {

                outputComponent = this.Tree.Draw();

            }

            return outputComponent;

        } catch(Exception ex) {}

        return null;
    }
}