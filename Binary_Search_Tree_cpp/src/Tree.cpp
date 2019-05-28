#include<iostream>
#include"Node.cpp"

using namespace std;

/**
 * Tree
 * @param <T> type of elements
 */
template<typename T> class Tree {
private:
    Node<T> root;

public:
    /**
     * Search node with given value.
     * @param value value
     * @return node with given value
     * @throws Exception if node not exist
     */
    Node<T> search(T value) {
        return search(value, root);
    }

    /**
     * Add new node to tree.
     * @param value value
     */
    void insert(T value) {
        if (root == NULL) {
            root = Node<T>(value);
        } else {
            insert(value, root);
        }
    }

    /**
     * Delete node with given value
     * @param value value
     * @return true if node was delete, false otherwise
     */
    bool deleteElem(T value) {
        Node<T> parent();
        Node<T> Node();

        if (root.getValue().equals(value)) {
            
            if (root.getLeftNode() == NULL && root.getRightNode() == NULL) {
                root = NULL;
            } else if (root.getLeftNode() == NULL) {
                root = root.getRightNode();
            } else if (root.getRightNode() == NULL) {
                root = root.getLeftNode();
            } else {
                T maxValue = findMaxValue(root.getLeftNode());
                deleteElem(maxValue);
                root.setValue(maxValue);
            }

            return true;
        } else {
            try {
                parent = getParent(root, value);
                Node = search(value);
            } catch (string ex) {
                return false;
            }
        }

        if (Node.getLeftNode() == NULL && Node.getRightNode() == NULL) {

            if (parent.getLeftNode()  == Node) {
                parent.setLeftNode(NULL);
            } else {
                parent.setRightNode(NULL);
            }

        } else if (Node.getLeftNode() == NULL) {

            if (parent.getLeftNode()  == Node) {
                parent.setLeftNode(Node.getRightNode());
            } else {
                parent.setRightNode(Node.getRightNode());
            }

        } else if (Node.getRightNode() == NULL) {

            if (parent.getLeftNode()  == Node) {
                parent.setLeftNode(Node.getLeftNode());
            } else {
                parent.setRightNode(Node.getLeftNode());
            }

        } else {

            T maxValue = findMaxValue(Node.getLeftNode());
            deleteElem(maxValue);
            Node.setValue(maxValue);

        }

        return true;
    }

    void draw() {
        draw(root, 0);
    }

private:
    Node<T> search(T value, Node<T> Node) {
        if (Node == NULL)
            throw (string) "not exist";
        
        if (Node.getValue() == value)
            return Node;
        
        if (Node.getValue().compareTo(value) > 0)
            return search(value, Node.getLeftNode());
        return search(value, Node.getRightNode());
    }

    void insert(T value, Node<T> currNode) {
        if (currNode.getValue().compareTo(value) > 0) {

            if (currNode.getLeftNode() == NULL) {
                currNode.setLeftNode(Node<T>(value));
            } else {
                insert(value, currNode.getLeftNode());
            }

        } else if (currNode.getValue().compareTo(value) < 0) {

            if (currNode.getRightNode() == NULL) {
                currNode.setRightNode(Node<T>(value));
            } else {
                insert(value, currNode.getRightNode());
            }

        }
    }

    void draw(Node<T> currNode, int height) {
        if (currNode != NULL) {
            string pause = "";
            for (int  i = 0; i < height; i++)
                pause = pause + "   ";

            draw(currNode.getRightNode(), height + 1);
            cout << pause << currNode.getValue();
            draw(currNode.getLeftNode(), height + 1);
        }
    }

    Node<T> getParent(Node<T> currNode, T value) {
        if (currNode == NULL)
            throw (string) "not exist";

        if (currNode.getLeftNode() != NULL && currNode.getLeftNode().getValue().equals(value))
            return currNode;

        if (currNode.getRightNode() != NULL && currNode.getRightNode().getValue().equals(value))
            return currNode;

        if (currNode.getValue().compareTo(value) < 0)
            return getParent(currNode.getRightNode(), value);
        return getParent(currNode.getLeftNode(), value);
        
    }

    T findMaxValue(Node<T> Node) {
        while (Node.getRightNode() != NULL) {
            Node = Node.getRightNode();
        }

        return Node.getValue();
    }
};