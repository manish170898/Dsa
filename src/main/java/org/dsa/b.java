package org.dsa;

public class b{
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        int[] nums1 = {1, 2, 2, 6, 1, 3};
        System.out.println(incremovableSubarrayCount(nums1));
    }
    public static long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;

        int leftIncreasing = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                leftIncreasing++;
            } else {
                break;
            }
        }

        // simplier to just return the answer when the whole nums is a strictly increasing sequence
        if (leftIncreasing == n) {
            return (1L + (long)n) * (long)n / 2L;
        }

        int rightIncreasing = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) {
                rightIncreasing++;
            } else {
                break;
            }
        }

        // find the patten of removing a subarray starts from i != 0 to i != n - 1
        long twinIncreasing = 0;
        int r = n - rightIncreasing;
        for (int l = 0; l < leftIncreasing; l++) {
            while (r < n && nums[l] >= nums[r]) {
                r++;
            }
            if (r == n) {
                break;
            }
            twinIncreasing += (long)(n - r);
        }

        // remember to add the case removing all numbers
        return ((long)leftIncreasing + (long)rightIncreasing + (long)twinIncreasing);

    }
}