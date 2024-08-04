package org.dsa.Dp;

import java.util.Arrays;

public class DP25RodCuttingProblem {
    public int cutRodTAb(int price[], int n) {
        //code here
        int[][] dp = new int[n][n+1];

        for(int rodLen=0; rodLen<=n; rodLen++){
            dp[0][rodLen] = (rodLen) * price[0];
        }

        for(int i=1; i<n; i++){
            for(int rodLen = 0; rodLen<=n; rodLen++){
                int notTake = dp[i-1][rodLen];
                int take = Integer.MIN_VALUE;
                if((i+1) <= rodLen){
                    take = price[i] + dp[i][rodLen-(i+1)];
                }
                dp[i][rodLen] = Math.max(take, notTake);
            }
        }

        return dp[n-1][n];
    }

    public int cutRodMemo(int price[], int n) {
        //code here
        int[][] dp = new int[n][n+1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return memoiz(n-1, n, price, dp);
    }

    public int memoiz(int index, int N, int prices[], int[][] dp){
        if(index == 0){
            return prices[index]*N;
        }
        if(dp[index][N]!= -1) return dp[index][N];
        int notTake = memoiz(index-1, N, prices, dp);
        int take = Integer.MIN_VALUE;
        if((index+1) <= N){
            take = prices[index] + memoiz(index, N-(index+1), prices, dp);
        }
        return dp[index][N] = Math.max(take,notTake);
    }
}
