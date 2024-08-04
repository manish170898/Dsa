package org.dsa.BinarySearch;

public class B17FindTheSmallestDivisorGivenAThreshold {
//    https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
    public int smallestDivisor(int[] nums, int threshold) {
        int maxNum = 0;
        for(int num : nums){
            if(num > maxNum) maxNum = num;
        }
        int low = 1, high = maxNum, mid = 0;
        int ans = 0;
        while(low<=high){
            mid = (low+high)/2;
            int val = calculateSum(nums, mid);
            if(val <= threshold){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int calculateSum(int[] nums, int mid){
        int sum = 0;
        for(int num : nums){
            sum+= Math.ceil((double)num/(double)mid);
        }
        return sum;
    }
}

