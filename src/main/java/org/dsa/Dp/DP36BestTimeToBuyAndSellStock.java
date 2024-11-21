package org.dsa.Dp;

public class DP36BestTimeToBuyAndSellStock {
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    public int maxProfit(int[] prices) {
        int minTillNow = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            int currentProfit = prices[i] - minTillNow;
            maxProfit = Math.max(maxProfit, currentProfit);
            minTillNow = Math.min(prices[i], minTillNow);
        }
        return maxProfit;
    }
}
