package org.dsa.SlidingWindowTwoPointers;

import java.util.Arrays;

public class Q6ThreeSumClosest {
//    https://leetcode.com/problems/3sum-closest/description/
    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        threeSumClosest(nums, -2);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        int j=n-1;
        int ans = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for(int k=1; k<n-1; k++){
            while(i < j){
                if(i == k){
                    i++;
                    continue;
                }
                if(j == k){
                    j--;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if((target < 0 && sum < 0) || (target >= 0 && sum >= 0)){
                    int diff = Math.abs(Math.abs(sum)-Math.abs(target));
                    if(diff < minDiff){
                        minDiff = diff;
                        ans = sum;
                    }
                }else{
                    int diff = Math.abs(sum)+Math.abs(target);
                    if(diff < minDiff){
                        minDiff = diff;
                        ans = sum;
                    }
                }
                if(sum < target) i++;
                if(sum > target) j--;
                if(sum == target) break;
            }
            i = 0;
            j = n-1;
        }
        return ans;
    }
}
