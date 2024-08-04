package org.dsa.Dp;

import java.util.Arrays;

public class D4FrogJump {
    public static void main(String[] args) {
//        https://www.naukri.com/code360/problems/frog-jump_3621012
    }
    public static int frogJump(int n, int heights[]) {
        // Write your code here
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recMemoization(n-1, dp, heights);
    }

    public static int recMemoization(int i, int[] dp, int[] height){
        if(i == 0){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int left = recMemoization(i-1, dp, height) + Math.abs(height[i-1] - height[i]);
        int right = Integer.MAX_VALUE;
        if(i >1){
            right = recMemoization(i-2, dp, height) + Math.abs(height[i-2] - height[i]);
        }
        return dp[i] = Math.min(right, left);
    }

    public static int tabulization(int n, int[] height){
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1; i<n; i++){
            int left = dp[i-1] +  Math.abs(height[i-1] - height[i]);
            int right = Integer.MAX_VALUE;
            if(i >1){
                right = dp[i-2] + Math.abs(height[i-2] - height[i]);
            }
            dp[i] = Math.min(right, left);
        }
        return dp[n-1];
    }

    public static int tabulizationSpaceOptimized(int n, int[] height){
        int prev = 0;
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int left = prev +  Math.abs(height[i-1] - height[i]);
            int right = Integer.MAX_VALUE;
            if(i >1){
                right =prev2 + Math.abs(height[i-2] - height[i]);
            }
            int cur = Math.min(right, left);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
