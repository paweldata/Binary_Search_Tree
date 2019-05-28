#include<iostream>

/**
 * Node of tree/
 * @param <T> type of elements
 * @author Paweł Data
 */
template<typename T> class Node {
private:
    T value;
    Node<T>* left;
    Node<T>* right;

public:

    /**
     * Class constructor.
     */
    Node(T v) {
        value = v;
        left = NULL;
        right = NULL;
    }

    T getValue() {
        return value;
    }

    /**
     * Set value.
     * @param value value
     */
    void setValue(T v) {
        value = v;
    }

    /**
     * Set left node.
     * @param node left node
     */
    void setLeftNode(Node<T>* node) {
        left = node;
    }

    /**
     * Get left node.
     * @return left node
     */
    Node<T> getLeftNode() {
        return left;
    }

    /**
     * Set right node.
     * @param node right node
     */
    void setRightNode(Node<T>* node) {
        right = node;
    }

    /**
     * Get right node.
     * @return right node
     */
    Node<T> getRightNode() {
        return right;
    }
};