package org.dsa.Dp;

public class D16PartitionEqualSubsetSum {
//    https://leetcode.com/problems/partition-equal-subset-sum/
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+= num;
        }
        if(sum%2 != 0) return false;
        sum = sum/2;
        return isSubsetSum(nums.length, nums, sum);
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean [][] dp = new boolean[N][sum+1];
        dp[0][0] = true;
        if(arr[0] <= sum) dp[0][arr[0]] = true;

        for(int i=1; i<N; i++){
            for(int s = 0; s<=sum; s++){
                boolean notTake = dp[i-1][s];
                boolean take = false;
                if(arr[i] <= s){
                    take = dp[i-1][s - arr[i]];
                }
                dp[i][s] = take || notTake;
                if(s == sum && dp[i][s]) return true;
            }
        }
        return false;
    }
}
