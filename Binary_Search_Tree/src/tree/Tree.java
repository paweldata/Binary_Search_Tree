package tree;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public T search(T value) throws Exception {
        return search(value, root);
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
    
}