//package org.dsa.Dp;
//
//import java.util.Arrays;
//
//public class D7HourseRobber2 {
////    https://leetcode.com/problems/house-robber-ii/description/
//    public static void main(String[] args) {
//        int[] nums = {200,3,140,20,10};;
//        System.out.println(rob(nums));
//    }
//    public static int rob(int[] nums) {
//        if(nums.length == 1){
//            return nums[0];
//        }
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        int a = recRobber(nums.length-2, 0,nums, dp);
//        Arrays.fill(dp, -1);
//        int b = recRobber(nums.length-1, 1,nums, dp);
//        return Math.max(a,b);
//    }
//
//    public static int recRobber(int index, int beggning, int[] nums, int[] dp){
//        if(index == beggning) return nums[beggning];
//        if(dp[index] != -1){
//            return dp[index];
//        }
//        int pick = nums[index];
//        if(index > beggning + 1){
//            pick += recRobber(index-2, beggning, nums, dp);
//        }
//        int notPick = recRobber(index-1, beggning, nums, dp);
//        return dp[index] = Math.max(pick, notPick);
//    }
//
//}
//
//class Solution {
//    public int rob(int[] nums) {
//        if (nums.length == 1) return nums[0];
//        if (nums.length == 2) return Math.max(nums[0], nums[1]);
//        int[] arr1 = new int[nums.length - 1];
//        int[] arr2 = new int[nums.length - 1];
//        for (int i = 0; i < arr1.length; i++) {
//            if (i == 0 || i == 1) arr1[i] = nums[i];
//            else if (i == 2) arr1[i] = nums[i] + arr1[i - 2];
//            else arr1[i] = nums[i] + Math.max(arr1[i - 2], arr1[i - 3]);
//        }
//        for (int i = 0; i < arr1.length; i++) {
//            if (i == 0 || i == 1) arr2[i] = nums[i + 1];
//            else if (i == 2) arr2[i] = nums[i + 1] + arr2[i - 2];
//            else arr2[i] = nums[i + 1] + Math.max(arr2[i - 2], arr2[i - 3]);
//        }
//        int i = (Math.max(arr1[arr1.length - 1], arr1[arr1.length - 2]));
//        int j = (Math.max(arr2[arr1.length - 1], arr2[arr1.length - 2]));
//        return Math.max(i, j);
//    }
