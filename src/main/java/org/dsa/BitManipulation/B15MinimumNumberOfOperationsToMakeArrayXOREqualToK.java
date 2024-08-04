package org.dsa.BitManipulation;

public class B15MinimumNumberOfOperationsToMakeArrayXOREqualToK {
//    https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/?envType=daily-question&envId=2024-04-29
    public int minOperations(int[] nums, int k) {
        int count = 0;
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }

        for(int i=0; i<31; i++){
            if((k & (1 << i)) != (xor & (1 << i))){
                count++;
            }
        }
        return count;
    }
}
