package org.dsa.BitManipulation;

public class B5RemoveLastSetBit {
    public static void main(String[] args) {
        int N = 13;
        System.out.println(N & (N-1));
    }
}
