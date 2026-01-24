package com.example.arraydeque;

import java.util.ArrayDeque;

public class ArrayDequeExample {

	public static void main(String[] args) {
        ArrayDeque<Integer> p = new ArrayDeque<>();
        p.add(2);
        p.remove();
        p.offerFirst(6);
        p.getLast();
        p.remove();
        // p.getLast(); // uncomment for error
        p.add(78);
        p.add(8);
        p.getFirst();
    }
}
