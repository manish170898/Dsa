package org.dsa.Dp;

import java.util.Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class DP37BestTimeToBuyAndSellStockII {
    public int maxProfitRec(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        return recRec(0, 1, prices, dp);
    }

    int recRec(int ind, int canBuy, int[] prices, int[][] dp){
        if(ind >= prices.length) return 0;
        if(dp[ind][canBuy] != -1) return dp[ind][canBuy];

        if(canBuy == 1){
            return dp[ind][canBuy] = Math.max(-prices[ind] + recRec(ind+1, 0, prices, dp), recRec(ind+1, 1, prices, dp));
        }
        else{
            return dp[ind][canBuy] = Math.max(prices[ind] + recRec(ind+1, 1, prices, dp), recRec(ind+1, 0, prices, dp));
        }
    }

    public int maxProfitTab(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int ind=n-1; ind>=0; ind--){
            for(int canBuy=0; canBuy<=1; canBuy++){
                if(canBuy == 1){
                    dp[ind][canBuy] = Math.max(-prices[ind] + dp[ind+1][0], dp[ind+1][1]);
                }
                else{
                    dp[ind][canBuy] = Math.max(prices[ind] + dp[ind+1][1], dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];
    }

}
