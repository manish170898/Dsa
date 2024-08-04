package org.dsa.BitManipulation;

public class B8MinBitsFlipToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int N = start ^ goal;
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
        return count;
    }
}
