package org.dsa.BitManipulation;

public class B4ClearithBit {
    public static void main(String[] args) {
        int N=9, i=2;
        int ithBitClear = N&(~(1<<i));
        System.out.println(ithBitClear);
    }
}
