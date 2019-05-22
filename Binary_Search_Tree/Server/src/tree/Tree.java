package tree;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JLabel;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public T search(T value) throws Exception {
        return search(value, this.root).getValue();
    }

    public void insert(T value) {
        insert(value, this.root);
    }

    public boolean delete(T value) {
        Node<T> Node;

        try {
            Node = search(value, this.root);
        } catch (Exception ex) {
            return false;
        }

        if (Node.getLeftNode() == null && Node.getRightNode() == null) {
            Node = null;
            return true;
        }

        if (Node.getLeftNode() == null && Node.getRightNode() != null) {
            Node = Node.getRightNode();
            return true;
        }

        if (Node.getLeftNode() != null && Node.getRightNode() == null) {
            Node = Node.getLeftNode();
            return true;
        }

        Node.setValue(findMinNode(Node));
        return true;
        
    }

    public Container Draw() {
        Container DrawnTree = new Container();
        DrawnTree.setLayout(new GridLayout(12,1));

        Queue<Node<T>> Queue = new LinkedList<>();
        Queue.add(this.root);

        int nodesInLine = 1;
        int nodesInCurrLine = 1;
        int nodesInNextLine = 0;
        while (nodesInCurrLine > 0) {
            Container Line = new Container();
            Line.setLayout(new GridLayout(1, nodesInLine));

            for (int i = 0; i < nodesInLine; i++) {
                Node<T> currNode = Queue.poll();

                if (currNode.getValue() == null) {
                    Line.add(new JLabel());
                    Queue.add(new Node<T>());
                    Queue.add(new Node<T>());
                } else {
                    Line.add(new JLabel(currNode.getValue() + ""));

                    if (currNode.getLeftNode() != null) {
                        Queue.add(currNode.getLeftNode());
                        nodesInNextLine++;
                    } else {
                        Queue.add(new Node<T>());
                    }

                    if (currNode.getRightNode() != null) {
                        Queue.add(currNode.getRightNode());
                        nodesInNextLine++;
                    } else {
                        Queue.add(new Node<T>());
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
        if (currNode == null) {
            currNode = new Node<T>(value);
            return;
        }

        if (currNode.getValue().compareTo(value) > 0) {
            insert(value, currNode.getLeftNode());
            return;
        }

        if (currNode.getValue().compareTo(value) < 0) {
            insert(value, currNode.getRightNode());
            return;
        }
    }

    private T findMinNode(Node<T> currNode) {
        if (currNode.getLeftNode() != null)
            return findMinNode(currNode);
        
        T tempValue = currNode.getValue();
        currNode = currNode.getRightNode();
        return tempValue;
    }
}