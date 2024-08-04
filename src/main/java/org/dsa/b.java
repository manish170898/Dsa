package org.dsa;

import java.util.HashMap;
import java.util.Map;
// Java program to demonstrate lambda expressions to
// implement a user defined functional interface.

@FunctionalInterface
interface Square {
    int calculate(int x);
    default int c(){
        System.out.println("asdasd");
        return 0;
    }
}

class Test {
    public static void main(String args[])
    {
        int a = 5;

        // lambda expression to define the calculate method
        Square s = (int x) -> x * x;

        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);
    }
}
