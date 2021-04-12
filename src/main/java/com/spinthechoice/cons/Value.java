package com.spinthechoice.cons;

import java.util.Iterator;

public final class Value<T> implements Cons<T> {
    private static class ConsIterator<T> implements Iterator<T> {
        private Cons<T> current;

        ConsIterator(final Cons<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return !current.isEmpty();
        }

        @Override
        public T next() {
            final T value = current.head();
            current = current.tail();
            return value;
        }
    }

    private final T value;
    private final Cons<T> tail;

    private Value(final T value) {
        this(value, Empty.getInstance());
    }

    private Value(final T value, final Cons<T> tail) {
        this.value = value;
        this.tail = tail;
    }

    @Override
    public T head() {
        return value;
    }

    @Override
    public Cons<T> tail() {
        return tail;
    }

    @Override
    public Value<T> add(final T next, final int index) {
        if (index == 0) {
            return new Value<>(next, this);
        } else {
            return new Value<>(value, tail().add(next, index - 1));
        }
    }

    @Override
    public Value<T> add(final T next) {
        return add(next, Integer.MAX_VALUE);
    }

    @Override
    public Cons<T> remove(final T element) {
        if (value == element) {
            return tail();
        } else {
            return new Value<>(value, tail.remove(element));
        }
    }

    @Override
    public boolean contains(final T element) {
        return value == element || tail().contains(element);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConsIterator<>(this);
    }

    public static <E> Cons<E> of(final E value) {
        return new Value<>(value);
    }

    @SafeVarargs
    public static <E> Cons<E> of(final E... values) {
        if (values == null || values.length == 0) {
            return Empty.getInstance();
        } else {
            return of(values, 0);
        }
    }

    private static <E> Cons<E> of(final E[] values, final int offset) {
        if (offset == values.length) {
            return Empty.getInstance();
        } else {
            return new Value<>(values[offset], of(values, offset + 1));
        }
    }
}
