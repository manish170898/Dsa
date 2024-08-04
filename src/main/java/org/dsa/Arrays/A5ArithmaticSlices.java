package org.dsa.Arrays;

//An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
//
//        For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
//        Given an integer array nums, return the number of arithmetic subarrays of nums.
//
//        A subarray is a contiguous subsequence of the array.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3,4]
//        Output: 3
//        Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
//        Example 2:
//
//        Input: nums = [1]
//        Output: 0


public class A5ArithmaticSlices {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,6,8,10,13,16};
        int curr = 0, total = 0;
        for (int i=2; i<nums.length; i++)
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                curr += 1;
                total += curr;
            } else {
                curr = 0;
            }
        System.out.println(total);
    }
}



/// 4 3 2 1

/// 5 3 2

// 6 4 3 2



