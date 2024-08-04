package org.dsa.BitManipulation;

public class B10SingleNumber {
//    https://leetcode.com/problems/single-number/
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i=0; i<= nums.length-1; i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
