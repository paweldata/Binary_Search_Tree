#include<iostream>
#include"Node.cpp"

using namespace std;

/**
 * Tree.
 * @param <T> type of elements
 */
template<typename T> class Tree {
private:
    Node<T>* root;
    string info;

public:

    /**
     * Class constructor.
     */
    Tree() {
       this->root = NULL;
       this->info = "";
    }
    /**
     * Search node with given value.
     * @param value value
     * @return node with given value
     * @throws Exception if node not exist
     */
    void searchElement(T value) {
        try {
            Node<T>* node = search(value);
            this->info = "Element exists";
        } catch(string ex) {
            this->info = "Element doesn't exist";
        }
    }

    /**
     * Add new node to tree.
     * @param value value
     */
    void insertElement(T value) {
        if (this->root == NULL) {
            this->root = new Node<T>(value);
        } else {
            insert(value, this->root);
        }

        this->info = "";
        draw();
    }

    void deleteElement(T value) {
        if (deleteElem(value)) {
            this->info = "";
        } else {
            this->info = " Element doesn't exist";
        }
        
    }

    /**
     * Delete node with given value
     * @param value value
     * @return true if node was delete, false otherwise
     */
    bool deleteElem(T value) {
        Node<T>* parent;
        Node<T>* Node;

        if (this->root->getValue() == value) {
            
            if (this->root->getLeftNode() == NULL && this->root->getRightNode() == NULL) {
                this->root = NULL;
            } else if (this->root->getLeftNode() == NULL) {
                this->root = this->root->getRightNode();
            } else if (this->root->getRightNode() == NULL) {
                this->root = this->root->getLeftNode();
            } else {
                T maxValue = findMaxValue(this->root->getLeftNode());
                deleteElem(maxValue);
                this->root->setValue(maxValue);
            }

            return true;
        } else {
            try {
                parent = getParent(this->root, value);
                Node = search(value);
            } catch (string ex) {
                return false;
            }
        }

        if (Node->getLeftNode() == NULL && Node->getRightNode() == NULL) {

            if (parent->getLeftNode()  == Node) {
                parent->setLeftNode(NULL);
            } else {
                parent->setRightNode(NULL);
            }

        } else if (Node->getLeftNode() == NULL) {

            if (parent->getLeftNode()  == Node) {
                parent->setLeftNode(Node->getRightNode());
            } else {
                parent->setRightNode(Node->getRightNode());
            }

        } else if (Node->getRightNode() == NULL) {

            if (parent->getLeftNode()  == Node) {
                parent->setLeftNode(Node->getLeftNode());
            } else {
                parent->setRightNode(Node->getLeftNode());
            }

        } else {

            T maxValue = findMaxValue(Node->getLeftNode());
            deleteElem(maxValue);
            Node->setValue(maxValue);

        }

        return true;
    }

    /**
     * Draws tree.
     */
    void draw() {
        draw(this->root, 0);
        cout << info << "\n";
    }

private:
     Node<T>* search(T value) {
        return search(value, this->root);
    }

    Node<T>* search(T value, Node<T>* Node) {
        if (Node == NULL)
            throw (string) "not exist";
        
        if (Node->getValue() == value)
            return Node;
        
        if (Node->getValue() > value)
            return search(value, Node->getLeftNode());
        return search(value, Node->getRightNode());
    }

    void insert(T value, Node<T> *currNode) {
        if (currNode->getValue() > value) {

            if (currNode->getLeftNode() == NULL) {
                //Node<T> node = Node<T>(value);
                //currNode->setLeftNode(&node);
                currNode->setLeftNode(new Node<T>(value));
            } else {
                insert(value, currNode->getLeftNode());
            }

        } else if (currNode->getValue() < value) {

            if (currNode->getRightNode() == NULL) {
                currNode->setRightNode(new Node<T>(value));
            } else {
                insert(value, currNode->getRightNode());
            }

        }
    }

    void draw(Node<T> *currNode, int height) {
        if (currNode != NULL && currNode != 0) {

            string pause = "";
            for (int  i = 0; i < height; i++)
                pause = pause + "   ";

            draw(currNode->getRightNode(), height + 1);
            cout << pause << currNode->getValue() << "\n";
            draw(currNode->getLeftNode(), height + 1);
        }
    }

    Node<T>* getParent(Node<T> *currNode, T value) {
        if (currNode == NULL)
            throw (string) "not exist";

        if (currNode->getLeftNode() != NULL && currNode->getLeftNode()->getValue() == value)
            return currNode;

        if (currNode->getRightNode() != NULL && currNode->getRightNode()->getValue() == value)
            return currNode;

        if (currNode->getValue() < value)
            return getParent(currNode->getRightNode(), value);
        return getParent(currNode->getLeftNode(), value);
        
    }

    T findMaxValue(Node<T> *Node) {
        while (Node->getRightNode() != NULL) {
            Node = Node->getRightNode();
        }

        return Node->getValue();
    }
};