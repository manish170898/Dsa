package org.dsa.SlidingWindowTwoPointers;

public class Q11CountNumberOfNiceSubarrays {
//    https://leetcode.com/problems/count-number-of-nice-subarrays/description/
    public int numberOfSubarrays(int[] nums, int k) {
        int a = atMostGoal(nums, k);
        int b = atMostGoal(nums, k-1);
        return a-b;
    }

    public int atMostGoal(int[] nums, int k){
        if(k<0) return 0;
        int l=0, r=0;
        int count=0;
        int ans=0;
        while(r < nums.length){
            count+= nums[r]%2;
            while(count > k){
                count-= nums[l]%2;
                l++;
            }
            ans+= r-l+1;
            r++;
        }
        return ans;
    }
}
