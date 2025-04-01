package edu.grinnell.csc207.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary tree that satisifies the binary search tree invariant.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    ///// From the reading

    /**
     * A node of the binary search tree.
     */
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        /**
         * @param value the value of the node
         * @param left  the left child of the node
         * @param right the right child of the node
         */
        Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * @param value the value of the node
         */
        Node(T value) {
            this(value, null, null);
        }
    }

    private Node<T> root;

    /**
     * Constructs a new empty binary search tree.
     */
    public BinarySearchTree() {
    }

    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /**
     * @return the number of elements in the tree
     */
    public int size() {
        return sizeH(root);
    }

    private Node<T> insertH(T value, Node<T> root) {
        if (root == null) {
            return new Node<T>(value);
        } else {
            if (value.compareTo(root.value) < 0) {
                root.left = insertH(value, root.left);
            } else {
                root.right = insertH(value, root.right);
            }
            return root;
        }
    }

    /**
     * @param value the value to add to the tree
     */
    public void insert(T value) {
        root = insertH(value, root);
    }

    ///// Part 1: Traversals

    /**
     * @return the elements of this tree collected via an in-order traversal
     */
    public List<T> toListInorder() {
        //
        List<T> inorderList = new ArrayList<T>();
        inorderHelper(inorderList, root);
        return inorderList;
    }

    private List<T> inorderHelper(List<T> list, Node<T> cur) {
        if (cur == null) {
            return list;
        } else {
            inorderHelper(list, cur.left);
            list.add(cur.value);
            inorderHelper(list, cur.right);
        }
        return list;
    }

    /**
     * @return the elements of this tree collected via a pre-order traversal
     */
    public List<T> toListPreorder() {
        List<T> preorderList = new ArrayList<T>();
        preorderHelper(preorderList, root);
        return preorderList;
    }

    private List<T> preorderHelper(List<T> list, Node<T> cur) {
        if (cur == null) {
            return list;
        } else {
            list.add(cur.value);
            preorderHelper(list, cur.left);
            preorderHelper(list, cur.right);
        }
        return list;
    }

    /**
     * @return the elements of this tree collected via a post-order traversal
     */
    public List<T> toListPostorder() {
        List<T> postorderList = new ArrayList<T>();
        postorderHelper(postorderList, root);
        return postorderList;
    }

    private List<T> postorderHelper(List<T> list, Node<T> cur) {
        if (cur == null) {
            return list;
        } else {
            postorderHelper(list, cur.left);
            postorderHelper(list, cur.right);
            list.add(cur.value);
        }
        return list;
    }

    ///// Part 2: Contains

    /**
     * @param value the value to search for
     * @return true iff the tree contains <code>value</code>
     */
    public boolean contains(T value) {
        return containsHelper(value, root);
    }

    private boolean containsHelper(T v, Node<T> cur) {
        if (cur == null) {
            return false;
        } else if (v.compareTo(cur.value) < 0) {
            containsHelper(v, cur.left);
        } else if (v.compareTo(cur.value) == 0) {
            return true;
        } else {
            containsHelper(v, cur.right);
        }
        return false;
    }

    ///// Part 3: Pretty Printing

    /**
     * @return a string representation of the tree obtained via an pre-order
     *         traversal in the
     *         form: "[v0, v1, ..., vn]"
     */

    public String toStringPreorder() {
        StringBuffer preOrderString = new StringBuffer("[");
        List<T> list = new ArrayList<T>();
        preorderHelper(list, root);
        if(list.size() > 0){
            preOrderString.append(list.get(0));
            for (int i = 1; i < list.size(); i++){
                preOrderString.append(", ");
                preOrderString.append(list.get(i));
            }
        }
        preOrderString.append("]");
        return preOrderString.toString();
    }


    ///// Part 4: Deletion

    /*
     * The three cases of deletion are:
     * 1. no children
     * 2. one child
     * 3. two children
     */

    /**
     * Modifies the tree by deleting the first occurrence of <code>value</code>
     * found
     * in the tree.
     *
     * @param value the value to delete
     */
    public void delete(T value) {
        if (!contains(value)) {
            throw new IllegalArgumentException();
        }
        deleteH(value, root);
    }

    private Node<T> deleteH(T value, Node<T> root) {
        if (root == null) {
            return null;
        } else if (value.compareTo(root.value) < 0) {
            root.left = deleteH(value, root.left);
        } else if (value.compareTo(root.value) > 0) {
            root.right = deleteH(value, root.right);
        } else {
            // replacement case
            // find the rightmost on the left tree, and up + reorganizes
    }
    return null;
}
}
