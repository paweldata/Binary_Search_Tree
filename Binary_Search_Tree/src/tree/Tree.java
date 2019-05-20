package tree;

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