package tree;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public T search(T value) throws Exception {
        return search(value, this.root);
    }

    public void insert(T value) {
        insert(value, this.root);
    }

    public void delete(T value) {
        delete(value, this.root);
    }

    private T search(T value, Node<T> Node) throws Exception {
        if (Node == null)
            throw new NullPointerException();
        
        if (Node.getValue().equals(value))
            return value;
        
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

    /*private void delete(T value , Node<T> currNode) {
        if (currNode == null)
            return;
        
        if (currNode.getLeftNode() == null && currNode.getRightNode() == null) {

        }
    }*/
}