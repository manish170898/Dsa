package org.dsa.Recursion;

public class R17CountGoodNumbers {
    public static long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = (n+1)/2;

        return (int)(myPow(5,even) * myPow(4,odd) % MOD);

    }

    public static long myPow(long x, long n) {
        long ans = 1;
        long nn = n;
        while(nn>0){
            if(nn%2 == 1){
                ans = (ans * x)%MOD;
                nn = nn-1;
            }
            if(nn%2 == 0){
                x = (x*x) %MOD;
                nn = nn/2;
            }
        }
        return ans;
    }
}
