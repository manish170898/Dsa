package org.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a{
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        int[] nums1 = {1, 2, 2, 6, 1, 3};
        System.out.println(incremovableSubarrayCount(nums1));
    }
    public static long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n == 2) {
            return 3;
        }

        long ans = 0; // removing all would be a solution

        // left increasing
        int left = 0;
        while(left < n-1 && nums[left] <= nums[left+1]) {
            left++;
        }
        ans += left + 1l;

        // right increasing
        int right = n-1;
        while(right > 0 && nums[right-1] <= nums[right]) {
            right--;
        }
        ans += n - right;

        // if all are increasing
        if(left >= right) {
            return ((n)*(n+1))/2l;
        }



        left = 0;
        // middle handling
        while(left < right && right < n) {
            if(nums[left] <= nums[right]) {
                ans += right == n-1 ? 1l : (long)(n-right);
                if(left < n-1 && nums[left] < nums[left+1])
                    left++;
                else
                    break;
            } else {
                right++;
            }
        }

        return ans;
    }
}