package org.dsa.BitManipulation;

public class B2CheckIfithBitSetOrNot {
    public static void main(String[] args) {
        int N = 1, i=0;

        if((N & (1 << i)) != 0){
            System.out.println("Set");
        }
        else {
            System.out.println("Not Set");
        }
    }
}
