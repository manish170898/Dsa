package org.dsa.SlidingWindowTwoPointers;


//https://leetcode.com/problems/max-consecutive-ones-iii/
public class Q3MaxConsecutiveOnesIII {
//    TC -O(2*n)
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int kCnt = 0;
        int ans = 0;
        while(i<nums.length){
            if(nums[i] == 0){
                kCnt++;
            }
            while(kCnt > k){
                if(nums[j] == 0){
                    kCnt --;
                }
                j++;
            }
            ans = Math.max(ans, i-j+1);
            i++;
        }
        return ans;
    }

    public int longestOnesOptimal(int[] nums, int k) {
        int i=0;
        int j=0;
        int kCnt = 0;
        int ans = 0;
        while(i<nums.length){
            if(nums[i] == 0) {
                kCnt++;
            }
            if(kCnt > k){
                if(nums[j] == 0){
                    kCnt --;
                }
                j++;
            }
            if(kCnt <= k) {
                ans = Math.max(ans, i - j + 1);
            }
            i++;
        }
        return ans;
    }
}
