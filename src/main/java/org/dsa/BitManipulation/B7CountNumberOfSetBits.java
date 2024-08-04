package org.dsa.BitManipulation;

public class B7CountNumberOfSetBits {
    public static void main(String[] args) {
        int N=13;
        int count = 0;
        while(N>1){
            // N&1 to check if number is odd
             count += N & 1;
             // To Divide number by 2
             N = N>>1;
        }
        if(N==1){
            count++;
        }
        System.out.println(count);
        int start  = 10, goal = 7;
        System.out.println(start ^ goal);
    }
}
