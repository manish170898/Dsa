package org.dsa.Arrays;

/*

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Input:
[7,9,7,4,2,8,7,7,1,5]

Expected:
7
 */

public class A12DuplicateInArrayNplusOne {

    // With sorting
//    public int findDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        int temp = -1;
//        for(int i=0; i<nums.length; i++){
//            if(i==0){
//                continue;
//            }
//            if(nums[i]!=i+1){
//                if(nums[i] == nums[i-1]){
//                    return nums[i];
//                }
//            }
//
//        }
//        return 0;
    public static void main(String[] args) {
        // Without sorting
        int[] nums = {9, 7, 4, 2, 8, 7, 7, 1, 5};
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                j = nums[i] - 1;
                if (nums[i] != nums[j]) {
                    nums[i] ^= nums[j];
                    nums[j] ^= nums[i];
                    nums[i] ^= nums[j];
                } else {
                    System.out.println(nums[i]);
                    break;
                }
                i++;
            } else {
                i++;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
    }

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]);
            if (nums[ind] < 0) {
                return ind;
            }
            nums[ind] = -nums[ind];
        }
        return -1;
    }
}


