package org.dsa.Dp;

import java.util.Arrays;

public class D6HouseRobber {
//    https://leetcode.com/problems/house-robber/
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recRobber(nums.length-1, nums, dp);
    }

    public static int recRobber(int index, int[] nums, int[] dp){
        if(index == 0) return nums[0];
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = nums[index];
        if(index > 1){
            pick += recRobber(index-2, nums, dp);
        }
        int notPick = recRobber(index-1, nums, dp);
        return dp[index] = Math.max(pick, notPick);
    }

    public static int tabRobber(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            int pick = nums[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.length-1];
    }

}
