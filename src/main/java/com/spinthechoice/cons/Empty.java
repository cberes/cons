package com.spinthechoice.cons;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Empty<T> implements Cons<T> {
    private static final Empty<Object> SINGLETON = new Empty<>();

    @SuppressWarnings("unchecked")
    public static <E> Empty<E> getInstance() {
        return (Empty<E>) SINGLETON;
    }

    private Empty() {
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T head() {
        throw new NoSuchElementException();
    }

    @Override
    public Cons<T> tail() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Cons<T> add(final T element) {
        return add(element, 0);
    }

    @Override
    public Cons<T> add(final T element, final int index) {
        return Value.of(element);
    }

    @Override
    public Cons<T> remove(final T element) {
        return this;
    }

    @Override
    public boolean contains(final T element) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                throw new NoSuchElementException();
            }
        };
    }
}
