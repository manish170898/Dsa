package org.dsa.Dp;

import java.util.Arrays;

public class D24UnboundedKnapsack {
    public static void main(String[] args) {
        int N = 2;
        int W = 3;
        int[] val = {1, 1};
        int[] wt = {2, 1};

        knapSack(N,W,val,wt);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][W+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return memoiz(N-1, N, W, val, wt, dp);
    }

    public static int memoiz(int index, int N, int W, int[] val, int[] wt, int[][] dp){
        if(index == 0){
            return (W/wt[0])*val[0];
        }
        if(dp[index][W] != -1) return dp[index][W];

        int take = Integer.MIN_VALUE;
        if(wt[index] <= W){
            take = val[index] + memoiz(index, N, W-wt[index], val, wt, dp);
        }
        int notTake = memoiz(index-1, N, W, val, wt, dp);
        return dp[index][W] = Math.max(take, notTake);
    }

    static int knapSackTab(int N, int W, int val[], int wt[])
    {
        int[][] dp =new int[N][W+1];

        for(int weight = 0; weight <=W; weight ++){
            if(wt[0]<= weight){
                dp[0][weight] = (weight/wt[0])*val[0] ;
            }
            else{
                dp[0][weight] = 0;
            }
        }

        for(int i=1; i<N; i++){
            for(int weight = 0; weight <= W; weight++){
                int notTake = dp[i-1][weight];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= weight){
                    take = val[i] + dp[i][weight - wt[i]];
                }
                dp[i][weight] = Math.max(take, notTake);
            }
        }

        return dp[N-1][W];
    }
}
