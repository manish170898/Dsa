package org.dsa.BitManipulation;

public class B6CheckIfNumberIfPowerOf2 {
    public static void main(String[] args) {

    }
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE){
            return false;
        }
        if((n & (n-1)) == 0){
            return true;
        }
        return false;
    }
}
