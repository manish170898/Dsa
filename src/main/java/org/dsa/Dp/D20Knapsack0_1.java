package org.dsa.Dp;

import java.util.Arrays;

public class D20Knapsack0_1 {
//    https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[n][W+1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        // your code here
        return memoiz(n-1, W, wt, val, dp);
    }

    public static int memoiz(int index, int W, int wt[], int val[], int[][] dp){
        if(index == 0){
            if(W >= wt[0]){
                return val[0];
            }
            else{
                return 0;
            }
        }
        if(dp[index][W] != -1) return dp[index][W];
        int take = Integer.MIN_VALUE;
        if(wt[index] <= W){
            take = val[index] + memoiz(index-1, W-wt[index], wt, val, dp);
        }
        int notTake = memoiz(index - 1, W, wt, val, dp);
        return dp[index][W] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int n = 3;
        int W = 4;
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        tabulation(W, wt, val, n);
    }
    public static int tabulation(int maxWeight, int wt[], int val[], int n){
        int[][] dp = new int[n][maxWeight+1];

        for(int w = wt[0]; w <= maxWeight; w++){
            dp[0][w] = val[0];
        }

        for(int i=1; i<n; i++){
            for(int w=0; w<=maxWeight; w++){
                int take = Integer.MIN_VALUE;
                if(wt[i] <= w){
                    take = val[i] + dp[i-1][w-wt[i]];
                }
                int notTake = dp[i-1][w];
                dp[i][w] = Math.max(take, notTake);
            }
        }
        return dp[n-1][maxWeight];
    }

    public static int tabulationSpaceOptimized(int maxWeight, int wt[], int val[], int n){
        int[] prev = new int[maxWeight+1];
        int[] cur = new int[maxWeight+1];

        for(int w = wt[0]; w <= maxWeight; w++){
            prev[w] = val[0];
        }

        for(int i=1; i<n; i++){
            for(int w=0; w<=maxWeight; w++){
                int take = Integer.MIN_VALUE;
                if(wt[i] <= w){
                    take = val[i] + prev[w-wt[i]];
                }
                int notTake = prev[w];
                cur[w] = Math.max(take, notTake);
            }
            for(int k=0; k<maxWeight+1; k++){
                prev[k] = cur[k];
            }
        }
        return prev[maxWeight];
    }

    public static int tabulationSpaceOptimizedSingleRow(int maxWeight, int wt[], int val[], int n){
        int[] prev = new int[maxWeight+1];

        for(int w = wt[0]; w <= maxWeight; w++){
            prev[w] = val[0];
        }

        for(int i=1; i<n; i++){
            for(int w=maxWeight; w>=0; w--){
                int take = Integer.MIN_VALUE;
                if(wt[i] <= w){
                    take = val[i] + prev[w-wt[i]];
                }
                int notTake = prev[w];
                prev[w] = Math.max(take, notTake);
            }
        }
        return prev[maxWeight];
    }
}
