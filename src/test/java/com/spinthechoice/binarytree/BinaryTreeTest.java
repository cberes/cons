package com.spinthechoice.binarytree;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    @Test
    void testSize() {
        assertEquals(9, BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100).size());
    }

    @Test
    void testHeight() {
        assertEquals(4, BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100).height());
    }

    @Test
    void testMax() {
        assertEquals(100, BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100).max());
    }

    @Test
    void testMin() {
        assertEquals(-1, BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100).min());
    }

    @Test
    void testContains() {
        final var tree = BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100);
        assertFalse(tree.contains(99));
        assertTrue(tree.contains(11));
    }

    @Test
    void testRemoveMax() {
        final var tree = BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100);
        final int size = tree.size();
        final int value = tree.removeMax();
        assertEquals(100, value);
        assertEquals(size - 1, tree.size());
        assertFalse(tree.contains(value));
    }

    @Test
    void testRemoveMin() {
        final var tree = BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100);
        final int size = tree.size();
        final int value = tree.removeMin();
        assertEquals(-1, value);
        assertEquals(size - 1, tree.size());
        assertFalse(tree.contains(value));
    }

    @Test
    void testSizeWhenOneElement() {
        assertEquals(1, BinaryTree.of(7).size());
    }

    @Test
    void testHeightWhenOneElement() {
        assertEquals(1, BinaryTree.of(7).height());
    }

    @Test
    void testMaxWhenOneElement() {
        assertEquals(7, BinaryTree.of(7).max());
    }

    @Test
    void testMinWhenOneElement() {
        assertEquals(7, BinaryTree.of(7).min());
    }

    @Test
    void testContainsWhenOneElement() {
        final var tree = BinaryTree.of(7);
        assertFalse(tree.contains(99));
        assertTrue(tree.contains(7));
    }

    @Test
    void testRemoveMaxWhenOneElement() {
        final var tree = BinaryTree.of(7);
        assertThrows(UnsupportedOperationException.class, tree::removeMax);
    }

    @Test
    void testRemoveMinWhenOneElement() {
        final var tree = BinaryTree.of(7);
        assertThrows(UnsupportedOperationException.class, tree::removeMin);
    }

    @Test
    void testBreadthFirstTraversal() {
        final List<Integer> allValues = new LinkedList<>();
        BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100)
                .forEachBreadthFirst(allValues::add);
        assertArrayEquals(new Integer[] {7, 5, 9, 2, 6, 11, -1, 4, 100}, allValues.toArray(new Integer[0]));
    }

    @Test
    void testBreadthFirstTraversalWhenOneElement() {
        final List<Integer> allValues = new LinkedList<>();
        BinaryTree.of(7).forEachBreadthFirst(allValues::add);
        assertArrayEquals(new Integer[] {7}, allValues.toArray(new Integer[0]));
    }

    @Test
    void testDepthFirstTraversal() {
        final List<Integer> allValues = new LinkedList<>();
        BinaryTree.of(7, 5, 9, 6, 11, 2, 4, -1, 100)
                .forEachDepthFirst(allValues::add);
        assertArrayEquals(new Integer[] {7, 5, 2, -1, 4, 6, 9, 11, 100}, allValues.toArray(new Integer[0]));
    }

    @Test
    void testDepthFirstTraversalWhenOneElement() {
        final List<Integer> allValues = new LinkedList<>();
        BinaryTree.of(7).forEachDepthFirst(allValues::add);
        assertArrayEquals(new Integer[] {7}, allValues.toArray(new Integer[0]));
    }
}
