package org.dsa.SlidingWindowTwoPointers;

import java.util.HashMap;

public class Q16SubarrayWithKdifferentInteger {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        subarraysWithKDistinct(nums,k);
    }
//    https://leetcode.com/problems/subarrays-with-k-different-integers/?envType=daily-question&envId=2024-03-31
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int subWithMaxK = subarrayWithAtMostK(nums, k);
        int reducedSubWithMaxK = subarrayWithAtMostK(nums, k - 1);
        return subWithMaxK - reducedSubWithMaxK;
    }

    public static int subarrayWithAtMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            ans += right - left + 1; // Size of subarray
            right++;
        }

        return ans;
    }
}
