package org.dsa.BitManipulation;

public class B1Swap2Numbers {
    public static void main(String[] args) {
        int a = 5, b= 66;
        System.out.println("Before");
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("After");
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("A: " + a);
        System.out.println("B: " + b);
    }
}
