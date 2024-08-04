package org.dsa.BinarySearch;

public class B16MinimumNumberOfDaysToMakeMBouquets {
//    https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
    public int minDays(int[] bloomDay, int m, int k) {
        int maxBloomDay = 0;
        for(int day : bloomDay){
            if(day > maxBloomDay) maxBloomDay = day;
        }
        int low = 1, high = maxBloomDay, mid = 0;
        int ans = -1;
        while(low<=high){
            mid = (low+high)/2;
            int val = calculateBouquet(bloomDay, mid, k);
            if(val >= m){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int calculateBouquet(int[] bloomDay, int mid, int k){
        int bouquets = 0;
        int currCount = 0;
        int i=0;
        while(i<bloomDay.length){
            if(bloomDay[i] <= mid){
                currCount++;
            }
            else{
                currCount = 0;
            }
            if(currCount == k){
                bouquets++;
                currCount = 0;
            }
            i++;
        }
        return bouquets;
    }
}
