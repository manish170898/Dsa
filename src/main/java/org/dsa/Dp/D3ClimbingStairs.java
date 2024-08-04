package org.dsa.Dp;

public class D3ClimbingStairs {

//    https://leetcode.com/problems/climbing-stairs/description/
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return rec(n, dp);
    }

    public int rec(int n, int[] dp){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n-1] = rec(n-1, dp);
        dp[n-2] = rec(n-2, dp);
        return dp[n-1] + dp[n-2];
    }

    private static int tab(int n, int[] dp) {
        int prev2 = 0;
        int prev1 = 1;
        for(int i=0; i<n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
