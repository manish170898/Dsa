package org.dsa.Dp;

public class D22TargetSum {
//    https://leetcode.com/problems/target-sum/description/
//    Problem boiled to down to divide into 2 subsets with subtraction as given target which we have done previously
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num: nums){
            sum+= num;
        }
        int sumMinusD = (sum-target);
        if(sumMinusD % 2 != 0 || target > sum) return 0;
        int toBeCounted = sumMinusD/2;

        return perfectSum(nums, nums.length, toBeCounted);
    }

    public static int perfectSum(int arr[],int n, int sum)
    {
        int[][] dp = new int[n][sum+1];
        dp[0][0] = 1;
        if(arr[0] <= sum) dp[0][arr[0]]++;
        int MOD = (int)(1e9 +7);

        for(int i=1; i<n; i++){
            for(int s=0; s<=sum; s++){
                int notTake = dp[i-1][s];
                int take = 0;
                if(arr[i] <= s){
                    take = dp[i-1][s-arr[i]];
                }
                dp[i][s] = (take%MOD + notTake%MOD)%MOD;
            }
        }
        return dp[n-1][sum];
    }


}
