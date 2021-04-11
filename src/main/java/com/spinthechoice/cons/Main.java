package com.spinthechoice.cons;

public class Main {
    public static void main(final String[] args) {
        for (Integer i : Value.of(1, 1, 2, 3, 5, 8, 13, 21, 34)) {
            System.out.println(i);
        }
        System.out.println("* Remove 1:");
        for (Integer i : Value.of(1, 1, 2, 3, 5, 8, 13, 21, 34).remove(1)) {
            System.out.println(i);
        }
        System.out.println("* Remove 34:");
        for (Integer i : Value.of(1, 1, 2, 3, 5, 8, 13, 21, 34).remove(34)) {
            System.out.println(i);
        }
        System.out.println("* Add 34 to end:");
        for (Integer i : Value.of(1, 1, 2, 3, 5, 8, 13, 21, 34).add(34)) {
            System.out.println(i);
        }
        System.out.println("* Add 34 to beginning:");
        for (Integer i : Value.of(1, 1, 2, 3, 5, 8, 13, 21, 34).add(34, 0)) {
            System.out.println(i);
        }
        System.out.println("* Add 34 to second element:");
        for (Integer i : Value.of(1, 1, 2, 3, 5, 8, 13, 21, 34).add(34, 1)) {
            System.out.println(i);
        }
    }
}
