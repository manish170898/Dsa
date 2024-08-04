package org.dsa.Dp;

import java.util.Arrays;

public class D18CountSubsetSumEqualK {
//    https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
    public static void main(String[] args) {
    }
    public int perfectSum(int arr[],int n, int sum)
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
