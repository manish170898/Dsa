package org.dsa.BitManipulation;

public class B3SetithBit {
    public static void main(String[] args) {
        int N = 9, i = 2;

        int ithBitSet = (N|(1<<i));
        System.out.println(ithBitSet);
    }
}
