package org.dsa.SlidingWindowTwoPointers;

public class Q10BinarySubarraysWithSum {
//    https://leetcode.com/problems/binary-subarrays-with-sum/
    public int numSubarraysWithSum(int[] nums, int goal) {
        int a = atMostGoal(nums, goal);
        int b = atMostGoal(nums, goal-1);

        return a-b;
    }

    public int atMostGoal(int[] nums, int goal){
        if(goal<0) return 0;
        int l=0, r=0;
        int sum=0;
        int ans=0;
        while(r < nums.length){
            sum+= nums[r];
            while(sum > goal){
                sum-= nums[l];
                l++;
            }
            ans+= r-l+1;
            r++;
        }
        return ans;
    }
}
