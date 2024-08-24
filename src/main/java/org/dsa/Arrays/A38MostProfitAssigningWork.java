package org.dsa.Arrays;

public class A38MostProfitAssigningWork {
//    https://leetcode.com/problems/most-profit-assigning-work/?envType=daily-question&envId=2024-06-18
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int maxValue = 0;
        for(int i = 0 ;i<difficulty.length; i++){
            maxValue = Math.max(maxValue, difficulty[i]);
        }
        int[] jobs = new int[maxValue+1];
        for(int i=0; i<profit.length; i++){
            int valIndex = difficulty[i];
            jobs[valIndex] = Math.max(jobs[valIndex], profit[i]);
        }
        for(int i=1; i<jobs.length; i++){
            jobs[i] = Math.max(jobs[i], jobs[i-1]);
        }

        int ans = 0;
        for(int i=0; i<worker.length; i++){
            if(worker[i] > maxValue){
                ans += jobs[maxValue];
            }
            else{
                ans += jobs[worker[i]];
            }

        }
        return ans;
    }
}
