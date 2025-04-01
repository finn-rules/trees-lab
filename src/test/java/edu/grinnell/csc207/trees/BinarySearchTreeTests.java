package edu.grinnell.csc207.trees;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTests {

    private BinarySearchTree<Integer> makeSampleTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(5);
        tree.insert(0);
        tree.insert(7);
        tree.insert(11);
        tree.insert(6);
        return tree;
    }

    private BinarySearchTree<String> makeStringTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("Emily");
        tree.insert("Finn");
        tree.insert("Abby");
        tree.insert("Bobhb0");
        tree.insert("Osera");
        return tree;
    }

    private BinarySearchTree<Integer> makeNullTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        return tree;
    }

    @Test
    public void emptyTreeTest() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        assertEquals(0, tree.size());
    }

    @Test
    public void basicSizeInsertTest() {
        BinarySearchTree<Integer> tree = makeSampleTree();
        assertEquals(5, tree.size());
    }

    @Test
    public void basicToListInorderTest() {
        // N.B., need to upcast the Integer[] array to avoid a ClassCastException that
        // arises from downcasting the result of toArray to Integer[].
        assertArrayEquals((Object[]) new Integer[] {0, 5, 6, 7, 11},
                          makeSampleTree().toListInorder().toArray());
    }

    @Test
    public void basicToListPreorderTest() {
        assertArrayEquals((Object[]) new Integer[] {5, 0, 7, 6, 11},
                          makeSampleTree().toListPreorder().toArray());
    }

    @Test
    public void basicToListPostorderTest() {
        assertArrayEquals((Object[]) new Integer[] {0, 6, 11, 7, 5},
                          makeSampleTree().toListPostorder().toArray());
    }

    @Test
    public void basicContainsTest() {
        BinarySearchTree<Integer> tree = makeSampleTree();
        assertEquals(true, tree.contains(5));
        assertEquals(false, tree.contains(8));
    }

    @Test
    public void basicToStringPreorderTest() {
        assertEquals("[5, 0, 7, 6, 11]", makeSampleTree().toStringPreorder());
    }

    @Test
    public void stringToStringPreorderTest() {
        assertEquals("[Emily, Abby, Bobhb0, Finn, Osera]", makeStringTree().toStringPreorder());
    }

    @Test
    public void nullToStringPreorderTest() {
        assertEquals("[]", makeNullTree().toStringPreorder());
    }


    @Test
    public void basicDeleteTest() {
        BinarySearchTree<Integer> tree = makeSampleTree();
        assertEquals(5, tree.size());
        assertTrue(tree.contains(6));
        tree.delete(6);
        assertEquals(4, tree.size());
        assertFalse(tree.contains(6));
    }
}

