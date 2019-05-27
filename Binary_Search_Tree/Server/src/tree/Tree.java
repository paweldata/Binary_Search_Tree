package tree;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JLabel;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> search(T value) throws Exception {
        return search(value, this.root);
    }

    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node<T>(value);
        } else {
            insert(value, this.root);
        }
    }

    public boolean delete(T value) {
        Node<T> parent;
        Node<T> Node;

        if (this.root.getValue().equals(value)) {
            
            if (this.root.getLeftNode() == null && this.root.getRightNode() == null) {
                this.root = null;
            } else if (this.root.getLeftNode() == null) {
                this.root = this.root.getRightNode();
            } else if (this.root.getRightNode() == null) {
                this.root = this.root.getLeftNode();
            } else {
                T maxValue = findMaxValue(this.root.getLeftNode());
                delete(maxValue);
                this.root.setValue(maxValue);
            }

            return true;
        } else {
            try {
                System.out.println("Tu byłem");
                parent = getParent(this.root, value);
                System.out.println("Ojciec jest");
                Node = search(value);
                System.out.println("Node też");
            } catch (Exception ex) {
                return false;
            }
        }

        if (Node.getLeftNode() == null && Node.getRightNode() == null) {

            if (parent.getLeftNode()  == Node) {
                parent.setLeftNode(null);
            } else {
                parent.setRightNode(null);
            }

        } else if (Node.getLeftNode() == null) {

            if (parent.getLeftNode()  == Node) {
                parent.setLeftNode(Node.getRightNode());
            } else {
                parent.setRightNode(Node.getRightNode());
            }

        } else if (Node.getRightNode() == null) {

            if (parent.getLeftNode()  == Node) {
                parent.setLeftNode(Node.getLeftNode());
            } else {
                parent.setRightNode(Node.getLeftNode());
            }

        } else {

            T maxValue = findMaxValue(Node.getLeftNode());
            delete(maxValue);
            Node.setValue(maxValue);

        }

        return true;
    }

    public Container Draw() {
        Container DrawnTree = new Container();
        DrawnTree.setLayout(new GridLayout(12,1));
        Node<T> Sentinel = new Node<T>();

        Queue<Node<T>> Queue = new LinkedList<>();

        if (this.root == null)
            return DrawnTree;

        Queue.add(this.root);

        int nodesInLine = 1;
        int nodesInCurrLine = 1;
        int nodesInNextLine = 0;
        while (nodesInCurrLine > 0) {
            Container Line = new Container();
            Line.setLayout(new GridLayout(1, nodesInLine));

            for (int i = 0; i < nodesInLine; i++) {
                Node<T> currNode = Queue.poll();

                if (currNode == Sentinel) {
                    Line.add(new JLabel());
                    Queue.add(Sentinel);
                    Queue.add(Sentinel);
                } else {
                    Line.add(new JLabel(currNode.getValue() + "", JLabel.CENTER));

                    if (currNode.getLeftNode() != null) {
                        Queue.add(currNode.getLeftNode());
                        nodesInNextLine++;
                    } else {
                        Queue.add(Sentinel);
                    }

                    if (currNode.getRightNode() != null) {
                        Queue.add(currNode.getRightNode());
                        nodesInNextLine++;
                    } else {
                        Queue.add(Sentinel);
                    }
                }
            }

            DrawnTree.add(Line);
            nodesInLine*=2;
            nodesInCurrLine = nodesInNextLine;
            nodesInNextLine = 0;
        }

        return DrawnTree;
    }

    private Node<T> search(T value, Node<T> Node) throws Exception {
        if (Node == null)
            throw new NullPointerException();
        
        if (Node.getValue().equals(value))
            return Node;
        
        if (Node.getValue().compareTo(value) > 0)
            return search(value, Node.getLeftNode());
        return search(value, Node.getRightNode());
    }

    private void insert(T value, Node<T> currNode) {
        if (currNode.getValue().compareTo(value) > 0) {

            if (currNode.getLeftNode() == null) {
                currNode.setLeftNode(new Node<T>(value));
            } else {
                insert(value, currNode.getLeftNode());
            }

        } else if (currNode.getValue().compareTo(value) < 0) {

            if (currNode.getRightNode() == null) {
                currNode.setRightNode(new Node<T>(value));
            } else {
                insert(value, currNode.getRightNode());
            }

        }
    }

    private Node<T> getParent(Node<T> currNode, T value) throws Exception {
        if (currNode == null)
            throw new Exception();

        System.out.println("Tu jestem");

        if (currNode.getLeftNode() != null && currNode.getLeftNode().getValue().equals(value))
            return currNode;
        
        System.out.println("Teraz jestem tu");

        if (currNode.getRightNode() != null && currNode.getRightNode().getValue().equals(value))
            return currNode;

        if (currNode.getValue().compareTo(value) < 0)
            return getParent(currNode.getRightNode(), value);
        return getParent(currNode.getLeftNode(), value);
        
    }

    private T findMaxValue(Node<T> Node) {
        while (Node.getRightNode() != null) {
            Node = Node.getRightNode();
        }

        return Node.getValue();
    }
}