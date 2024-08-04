package org.dsa.Arrays;

import java.util.Arrays;

public class A27TwoSum {
    public static void main(String[] args) {

    }

    public static int [] twoSum(int[] nums, int target){
        Arrays.sort(nums);
        int i=0;
        int j= nums.length-1;
        while(i<j){
            if(nums[j] + nums[i] == target){
                return new int[]{i,j};
            } else if (nums[j] + nums[i] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}
