package org.dsa.Dp;

public class D2FibonacciNumbers {
//    https://leetcode.com/problems/fibonacci-number/description/
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        dpFibonacci(n, dp);
    }
// TC - O(N)  ... SC - O(N) as stack space fro recusive calls + O(N) as dp[] space
    private static int dpFibonacci(int n, int[] dp) {
        if(n<=1){
            return n;
        }
        if(dp[n] != -1) return dp[n];
        return dp[n] = dpFibonacci(n-1, dp) + dpFibonacci(n-2, dp);
    }

//    TC - O(N) SC - O(N)
    private static int dpFibonacciTabulation(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
// TC - O(N) SC - O(1)
    private static int dpFibonacciTabulationSpaceOptimized(int n, int[] dp) {
        int prev2 = 0;
        int prev1 = 1;
        for(int i=2; i<n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
