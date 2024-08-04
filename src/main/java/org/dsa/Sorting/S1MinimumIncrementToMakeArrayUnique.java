package org.dsa.Sorting;

import java.util.Arrays;

public class S1MinimumIncrementToMakeArrayUnique {
//    https://leetcode.com/problems/minimum-increment-to-make-array-unique/?envType=daily-question&envId=2024-06-15
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        int count = 0;
        while(i < nums.length){
            if(nums[i] <= nums[i-1]){
                count+= Math.abs(nums[i] - nums[i-1]) +1;
                nums[i] = nums[i-1]+1;
            }
            i++;
        }
        return count;
    }
}
