package org.dsa.BitManipulation;

public class B13XorOfNumberInGivenRange {
    public static void main(String[] args) {
        int N = 4;
    }
    public int Range(int L, int R){
        return xor(L-1) ^ xor(R);
    }

    public int xor(int N){
        int ans = 0;
        if(N%4 == 0) ans = N;
        if(N%4 == 1) ans = 1;
        if(N%4 == 2) ans = N+1;
        if(N%4 == 3) ans = 0;
        return ans;
    }
}
