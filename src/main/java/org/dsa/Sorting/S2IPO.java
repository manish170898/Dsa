package org.dsa.Sorting;

import java.util.PriorityQueue;

public class S2IPO {
//    https://leetcode.com/problems/ipo/?envType=daily-question&envId=2024-06-16
    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1,2,3}, capital = {0,1,1};
        findMaximizedCapital(k, w, profits, capital);

    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<PairPro> maxHeapProfit = new PriorityQueue<>((a, b) -> b.profit-a.profit);
        PriorityQueue<PairPro> minHeapCapital = new PriorityQueue<>((a, b) -> a.capital-b.capital);
        int ans = w;
        for(int i=0; i<capital.length; i++){
            minHeapCapital.add(new PairPro(profits[i], capital[i]));
        }
        while(k > 0){
            while(!minHeapCapital.isEmpty() && minHeapCapital.peek().capital <= w){
                maxHeapProfit.add(minHeapCapital.poll());
            }
            if(maxHeapProfit.isEmpty()) break;
            PairPro maxProfitForNow = maxHeapProfit.poll();
            ans += maxProfitForNow.profit;
            w += maxProfitForNow.profit;
            k--;
        }
        return ans;
    }
}


class PairPro{
    int profit;
    int capital;
    public PairPro(int profit, int capital){
        this.profit = profit;
        this.capital = capital;
    }
}

