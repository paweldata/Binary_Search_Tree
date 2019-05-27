package tree;

/**
 * Node of tree/
 * @param <T> type of elements
 * @author Paweł Data
 */
public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    /**
     * Class constructor.
     */
    public Node() {}

    /**
     * Class constructor.
     * @param value node's value
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Get value.
     * @return value
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Set value.
     * @param value value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Set left node.
     * @param node left node
     */
    public void setLeftNode(Node<T> node) {
        this.left = node;
    }

    /**
     * Get left node.
     * @return left node
     */
    public Node<T> getLeftNode() {
        return this.left;
    }

    /**
     * Set right node.
     * @param node right node
     */
    public void setRightNode(Node<T> node) {
        this.right = node;
    }

    /**
     * Get right node.
     * @return right node
     */
    public Node<T> getRightNode() {
        return this.right;
    }
}