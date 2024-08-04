package org.dsa.BitManipulation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class B11SingleNumber2 {
// TC - O(nLogN + n/3)
//    SC - O(1)
    public Integer optimized(int[] nums){
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i = 1+3){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }

    public Integer mostOptimized(int[] nums){
        int ones = 0;
        int twos = 0;
        for(int i=0; i< nums.length; i++){
            ones = (nums[i] ^ ones) & (~twos);
            twos = (nums[i] ^ twos) & (~ones);
        }
        return ones;
    }
}
