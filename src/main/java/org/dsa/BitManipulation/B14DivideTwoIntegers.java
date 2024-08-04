package org.dsa.BitManipulation;

public class B14DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(dividend == divisor){
            return 1;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        int ans = 0;
        long n = Math.abs((long)dividend), d = Math.abs((long)divisor);
        while(n >= d){
            int count = 0;
            while(n > (d << (count+1))){
                count ++;
            }
            n = n - (d<<count);
            ans += (1<<count);
        }


        if(isNegative){
            return -ans;
        }
        return ans;
    }
}
