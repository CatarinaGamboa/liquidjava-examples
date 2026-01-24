package com.example.simple;
import liquidjava.specification.Refinement;

public class SimpleExample {

    public static void main( String[] args ) {
        int a = 6;
        int b = 3;

        @Refinement("x > 0")
        int x = -(a / b);
    }
}
