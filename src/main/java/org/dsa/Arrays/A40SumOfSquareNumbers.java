package org.dsa.Arrays;

public class A40SumOfSquareNumbers {
//    https://leetcode.com/problems/sum-of-square-numbers/?envType=daily-question&envId=2024-06-17
    public boolean judgeSquareSum(int c) {
        long lo = 0;
        long hi = (long)Math.sqrt(c);
        while(lo <= hi){
            long t = lo*lo + hi*hi;
            if(t == c) return true;
            else if(t > c) hi--;
            else if(t < c) lo++;
        }
        return false;
    }
}
