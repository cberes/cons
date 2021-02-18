package com.example.interview;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ConsTest {
    @Test
    public void testIterate() {
        final List<Integer> allValues = new LinkedList<>();
        for (Integer i : Value.of(1, 1, 2, 3, 5, 8, 13, 21, 34)) {
            allValues.add(i);
        }
        assertArrayEquals(new Integer[] {1, 1, 2, 3, 5, 8, 13, 21, 34}, allValues.toArray(new Integer[0]));
    }

    @Test
    public void testSize() {
        assertEquals(9, Value.of(1, 1, 2, 3, 5, 8, 13, 21, 34).size());
    }

    @Test
    public void testTail() {
        final Cons<Integer> cons = Value.of(1, 50, 20, 15);
        assertEquals(3, cons.tail().size());
        assertEquals(50, (int) cons.tail().head());
    }

    @Test
    public void testContains() {
        final Cons<Integer> cons = Value.of(1, 50, 20, 15);
        assertTrue(cons.contains(1));
        assertTrue(cons.contains(50));
        assertTrue(cons.contains(20));
        assertTrue(cons.contains(15));
        assertFalse(cons.contains(2));
    }

    @Test
    public void testSingleElement() {
        assertEquals(1, Value.of(4).size());
        assertFalse(Value.of(4).isEmpty());
        assertEquals(4, (int) Value.of(4).head());
        assertTrue(Value.of(4).tail().isEmpty());
    }

    @Test
    public void testEmpty() {
        assertTrue(Value.<Integer>of().isEmpty());
        assertEquals(0, Value.<Integer>of().size());
        assertFalse(Value.<Integer>of().iterator().hasNext());
    }
}
