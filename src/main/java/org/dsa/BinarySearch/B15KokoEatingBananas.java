package org.dsa.BinarySearch;

public class B15KokoEatingBananas {
//    https://leetcode.com/problems/koko-eating-bananas/
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles){
            if(pile > maxPile) maxPile = pile;
        }
        int low = 1, high = maxPile, mid = 0;
        int ans = 0;
        while(low<=high){
            mid = (low+high)/2;
            int val = calculateHours(piles, mid);
            if(val <= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int calculateHours(int[] piles, int mid){
        int hours = 0;
        for(int pile: piles){
            hours+= Math.ceil(((double)pile/(double)mid));
        }
        return hours;
    }
}
