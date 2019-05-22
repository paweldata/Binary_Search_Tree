package tree;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node() {}

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeftNode(Node<T> node) {
        this.left = node;
    }

    public Node<T> getLeftNode() {
        return this.left;
    }

    public void setRightNode(Node<T> node) {
        this.right = node;
    }

    public Node<T> getRightNode() {
        return this.right;
    }

    public String toString() {
        return this.value + "";
    }
}