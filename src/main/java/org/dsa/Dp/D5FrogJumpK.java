package org.dsa.Dp;

import java.util.Arrays;

public class D5FrogJumpK {
    public static void main(String[] args) {
//        https://www.naukri.com/code360/problems/minimal-cost_8180930?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
    }
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recMemoization(n-1, dp, height, k);
    }

    public static int recMemoization(int i, int[] dp, int[] height, int k){
        if(i == 0){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int itr = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            int maxStep = Integer.MAX_VALUE;
            if(i-j >= 0){
                maxStep = recMemoization(i-j, dp, height, k) + Math.abs(height[i-j] - height[i]);
            }
            itr = Math.min(maxStep, itr);
        }

        return dp[i] = itr;
    }

    public static int tabulization(int n, int k, int []height){
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1; i<n; i++){
            int itr = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                int maxStep = Integer.MAX_VALUE;
                if(i-j >= 0){
                    maxStep = dp[i-j] + Math.abs(height[i-j] - height[i]);
                }
                itr = Math.min(maxStep, itr);
            }
            dp[i] = itr;
        }
        return dp[n-1];
    }
}
