package binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

public class BSTree<T extends Comparable<T>> implements BSTOper<T> {

    // Root node
    protected Node root;

    // Private node class for BST
    protected class Node {
        private Node left;
        private Node right;
        protected T data;

        protected Node(T data) {
            this.data = data;
        }

    }

    public BSTree() {
        root = null;
    }

    /**
     * Recursively find BST height and return height
     */
    public int size() {
        return size(this.root);
    }

    /**
     * Recursively find node with given value and return value
     */
    public Node find(T value) {
        return findRec(this.root, value);
    }

    /**
     * Recursively add node to BST
     */
    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            System.out.printf("Node with value %s added as root%n", value);
        } else {
            addRec(value, this.root);
        }
    }

    /**
     * Add all nodes from list to BST
     */
    public void addAll(ArrayList<T> objects) {
        for (T n : objects) {
            add(n);
        }
    }

    /**
     * Recursively find out if node has been removed from BST
     * and return true if node has been removed
     */
    public boolean remove(T value) {
        return removeRec(value, this.root) != null;
    }

    /**
     * Recursively check if a node with a given value is in tree,
     * return true if node is in tree
     */
    public boolean existsInTree(T value) {
        return findRec(this.root, value) != null;
    }

    /**
     * Sort node values in BST in inorder and return BST
     */
    public ArrayList<T> sortedArray() {
        ArrayList<T> sortedArr = new ArrayList<>();
        Stack<Node> nodes = new Stack<>();
        Node current = root;

        while (!nodes.isEmpty() || current != null) {
            if (current != null) {
                nodes.push(current);
                current = current.left;
            } else {
                Node node = nodes.pop();
                sortedArr.add(node.data);
                current = node.right;
            }
        }
        return sortedArr;
    }

    /**
     * Find and return node n's parent
     */
    public Node findParent(Node n) {
        return findParentHelper(this.root, n.data);
    }

    /**
     * Find and return node n's grandparent
     */
    public Node findGrandparent(Node n) {
        return findGrandparentHelper(this.root, n.data);
    }

    /**
     * Find and return closest element that is smaller than value
     */
    public T findNearestSmallerThan(T value) {
        Node found = find(value);
        Node foundParent = findParent(found);
        Node foundGrandparent = findGrandparent(found);

        if (found.left != null) {
            return found.left.data;
        } else if (found.data.compareTo(foundParent.data) > 0) {
            return foundParent.data;
        } else if (found.data.compareTo(foundParent.data) < 0
                && foundParent.data.compareTo(foundGrandparent.data) > 0) {
            return foundGrandparent.data;
        } else {
            return null;
        }
    }

    /**
     * Find and return all elements within a range
     */
    public ArrayList<T> findInRange(T low, T high) {
        ArrayList<T> nodesInRange = new ArrayList<>();
        ArrayList<T> sorted = sortedArray();

        for (T t : sorted) {
            if (low.compareTo(t) < 0 && high.compareTo(t) > 0) {
                nodesInRange.add(t);
            }
        }
        return nodesInRange;
    }

    /**
     * Start at root and print BST in inorder
     */
    public void printBST(Node root) {
        if (root == null) {
            return;
        }
        printBST(root.left);
        System.out.print(root.data + " ");
        printBST(root.right);
    }

    // -------------------- HELPER METHODS --------------------

    /**
     * Recursive method that returns size of BST
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(size(node.left), size(node.right));
        }
    }

    /**
     * Recursive helper method for add
     */
    private void addRec(T data, Node current) {
        if (data.compareTo(current.data) < 0) {
            if (current.left == null) {
                current.left = new Node(data);
                System.out.printf("Node with value %s added as left child%n", data);
            } else {
                addRec(data, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node(data);
                System.out.printf("Node with value %s added as right child%n", data);
            } else {
                addRec(data, current.right);
            }
        }
    }

    /**
     * Recursive method that returns node with given value
     */
    private Node findRec(Node current, T value) {
        if (current == null) {
            return null;
        }
        if (value == current.data) {
            return current;
        } else if (value.compareTo(current.data) < 0) {
            return findRec(current.left, value);
        } else {
            return findRec(current.right, value);
        }
    }

    /**
     * Recursive helper function that returns removed
     * nodes value
     */
    private Node removeRec(T value, Node current) {
        if (current == null) {
            System.out.println("Empty tree, nothing to delete");
            return null;
        }
        // Traversing down the tree
        if (current.data.compareTo(value) > 0) {
            current.left = removeRec(value, current.left);
        } else if (current.data.compareTo(value) < 0) {
            current.right = removeRec(value, current.right);
        } else {
            // One or no child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            // Two children. Get inorder successor
            current.data = minValInBST(current.right);
            current.right = removeRec(current.data, current.right);
        }
        return current;
    }

    /**
     * Find the smallest value from subtree where node is
     * and return its value
     */
    private T minValInBST(Node current) {
        T minVal = current.data;
        while (current.left != null) {
            minVal = current.left.data;
            current = current.left;
        }
        return minVal;
    }

    /**
     * Finds and returns parent nodes value
     */
    private Node findParentHelper(Node current, T val) {
        Node parent = null;

        // If node not in BST/empty BST
        if (current == null) {
            return null;
        }

        while (current != null) {
            if (val.compareTo(current.data) < 0) {
                parent = current;
                current = current.left;
            } else if (val.compareTo(current.data) > 0) {
                parent = current;
                current = current.right;
            } else if (current == root) {
                return null;
            } else {
                break;
            }
        }
        // Return parent if node is not null, else return null
        return current != null ? parent : null;
    }

    /**
     * Find and return grandparent nodes value
     */
    private Node findGrandparentHelper(Node current, T val) {
        Node parent = null;
        Node grandparent = null;

        // If node not in BST/empty BST
        if (current == null) {
            return null;
        }

        while (current != null) {
            if (val.compareTo(current.data) < 0) {
                grandparent = parent;
                parent = current;
                current = current.left;
            } else if (val.compareTo(current.data) > 0) {
                grandparent = parent;
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        // Return grandparent if node is not null, else return null
        return current != null ? grandparent : null;
    }
}
