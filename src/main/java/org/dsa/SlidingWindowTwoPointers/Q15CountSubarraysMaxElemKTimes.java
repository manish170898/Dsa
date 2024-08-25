package org.dsa.SlidingWindowTwoPointers;

public class Q15CountSubarraysMaxElemKTimes {
    public static void main(String[] args) {

    }

//    https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29
    public long countSubarrays(int[] nums, int k) {
        int mx= Integer.MIN_VALUE;
        for(int it : nums){
            mx=Math.max(mx,it);
        }
        int n=nums.length;
        int freq=0;
        int start=0;
        long ans=0;
        for(int end=0;end<n;end++){
            // Growing Phase
            if(nums[end]==mx){
                freq++;
            }
            //Shrinking Phase
            while(freq==k){
                ans = ans + (n-end);
                if(nums[start]==mx)
                    freq--;
                start++;
            }
        }
        return ans;
    }


}

