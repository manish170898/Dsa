package org.dsa.Dp;

import java.util.Arrays;

public class D21MinimumCoins {
//    https://leetcode.com/problems/coin-change/

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        int ans = memoiz(n-1, coins, amount, dp);
        return  ans == (int)(1e9)? -1 : ans ;
    }

    public int memoiz(int index, int[] coins, int amount, int[][] dp){
        if(index == 0){
            if(amount % coins[index] == 0) return amount / coins[index];
            else return (int)(1e9);
        }
        if(dp[index][amount] != -1) return dp[index][amount];
        int notTake = memoiz(index-1, coins, amount, dp);
        int take = Integer.MAX_VALUE;
        if(coins[index] <= amount){
            //Imp to undestand this
            take = 1 + memoiz(index, coins, amount - coins[index], dp);
        }
        return dp[index][amount] = Math.min(take, notTake);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        coinChangeTab(coins, amount);
    }

    public static int coinChangeTab(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int target = 0; target <= amount; target ++) {
            if (target % coins[0] == 0) dp[0][target] = target / coins[0];
            else dp[0][target] = (int)(1e9);
        }

        for(int ind = 1; ind< n; ind++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = dp[ind - 1][tar];
                int take = Integer.MAX_VALUE;
                if (coins[ind] <= tar) {
                    //Imp to undestand this why 1+ and the same index
                    take = 1 + dp[ind][tar - coins[ind]];
                }
                dp[ind][tar] = Math.min(take, notTake);
            }
        }
        if(dp[n-1][amount] == (int)(1e9)) return -1;
        else return dp[n-1][amount];
    }

}
