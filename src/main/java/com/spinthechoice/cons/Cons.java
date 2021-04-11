package com.spinthechoice.cons;

public interface Cons<T> extends Iterable<T> {
    default boolean isEmpty() {
        return false;
    }

    T head();

    Cons<T> tail();

    default int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return 1 + tail().size();
        }
    }

    Cons<T> add(T element);

    Cons<T> add(T element, int index);

    Cons<T> remove(T element);

    boolean contains(T element);
}
