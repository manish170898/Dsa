package org.dsa.BinarySearch;

public class B18CapacityToShipPackagesWithinDDays {
//    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        shipWithinDays(weights, days);
    }
    public static int shipWithinDays(int[] weights, int days) {
        int sumWeights = 0;
        for(int weight : weights){
            sumWeights += weight;
        }
        int low = 1, high = sumWeights, mid = 0;
        int ans = 0;
        while(low<=high){
            mid = (low+high)/2;
            int val = calculateDays(weights, mid);
            if(val <= days){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int calculateDays(int[] weights, int mid){
        int days = 0;
        int sum = 0;
        int i=0;
        while(i < weights.length){
            if(weights[i] > mid) return Integer.MAX_VALUE;
            sum += weights[i];
            if(sum == mid){
                sum = 0;
                days++;
            }
            else if(sum > mid){
                sum = weights[i];
                days++;
            }
            i++;
        }
        if(sum > 0) days ++;
        return days;
    }
}

