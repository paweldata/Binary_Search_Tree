package tree;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setLeftNode(Node<T> node) {
        this.left = node;
    }

    public void setRightNode(Node<T> node) {
        this.right = node;
    }

    public Node<T> getLeftNode() {
        return this.left;
    }

    public Node<T> getRightNode() {
        return this.right;
    }

    public String toString() {
        return this.value + "";
    }
}