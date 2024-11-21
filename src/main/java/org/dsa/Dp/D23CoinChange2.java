package org.dsa.Dp;

public class D23CoinChange2 {
//    https://leetcode.com/problems/coin-change-ii/description/
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        change(amount,coins);
    }
    public static int change(int amount, int[] coins) {
        int ans = tabulation(coins, amount);
        return  ans == (int)(1e9)? -1 : ans ;
    }

    public static int tabulation(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int target = 0; target <= amount; target ++) {
            if (target % coins[0] == 0) dp[0][target] = 1;
            else dp[0][target] = 0;
        }

        for(int ind = 1; ind< n; ind++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = dp[ind - 1][tar];
                int take = 0;
                if (coins[ind] <= tar) {
                    take = dp[ind][tar - coins[ind]];
                }
                dp[ind][tar] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }
}
