package com.spinthechoice.binarytree;

import java.util.LinkedList;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryTree<T> left, right;
    private final T value;

    public BinaryTree(final T value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 1
                + (left == null ? 0 : left.size())
                + (right == null ? 0 : right.size());
    }

    public int height() {
        return 1 + Math.max(
                left == null ? 0 : left.height(),
                right == null ? 0 : right.height());
    }

    public void add(final T newValue) {
        if (newValue.compareTo(value) < 0) {
            addLeft(newValue);
        } else {
            addRight(newValue);
        }
    }

    private void addLeft(final T newValue) {
        if (left == null) {
            left = new BinaryTree<>(newValue);
        } else {
            left.add(newValue);
        }
    }

    private void addRight(final T newValue) {
        if (right == null) {
            right = new BinaryTree<>(newValue);
        } else {
            right.add(newValue);
        }
    }

    public T min() {
        if (left == null) {
            return value;
        } else {
            return left.min();
        }
    }

    public T max() {
        if (right == null) {
            return value;
        } else {
            return right.max();
        }
    }

    public T removeMin() {
        if (left == null) {
            throw new UnsupportedOperationException("cannot remove the root node");
        } else if (left.left == null) {
            return getAndUnsetLeft();
        } else {
            return left.removeMin();
        }
    }

    private T getAndUnsetLeft() {
        T min = left.value;
        left = null;
        return min;
    }

    public T removeMax() {
        if (right == null) {
            throw new UnsupportedOperationException("cannot remove the root node");
        } else if (right.right == null) {
            return getAndUnsetRight();
        } else {
            return right.removeMax();
        }
    }

    private T getAndUnsetRight() {
        T max = right.value;
        right = null;
        return max;
    }

    public boolean contains(final T search) {
        if (search.equals(value)) {
            return true;
        } else if (search.compareTo(value) < 0) {
            return left != null && left.contains(search);
        } else {
            return right != null && right.contains(search);
        }
    }

    public void forEachBreadthFirst(final Consumer<T> action) {
        final LinkedList<BinaryTree<T>> unvisited = new LinkedList<>();
        unvisited.add(this);

        while (!unvisited.isEmpty()) {
            visit(action, unvisited);
        }
    }

    private void visit(final Consumer<T> action, final LinkedList<BinaryTree<T>> unvisited) {
        final BinaryTree<T> current = unvisited.poll();
        action.accept(current.value);
        if (current.left != null) {
            unvisited.add(current.left);
        }
        if (current.right != null) {
            unvisited.add(current.right);
        }
    }

    public void forEachDepthFirst(final Consumer<T> action) {
        action.accept(value);
        if (left != null) {
            left.forEachDepthFirst(action);
        }
        if (right != null) {
            right.forEachDepthFirst(action);
        }
    }

    @SafeVarargs
    public static <E extends Comparable<E>> BinaryTree<E> of(final E rootValue, final E... values) {
        final BinaryTree<E> root = new BinaryTree<>(rootValue);
        if (values != null) {
            for (E value : values) {
                root.add(value);
            }
        }
        return root;
    }
}
