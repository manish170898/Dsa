package org.dsa.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class S3SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }
//    https://leetcode.com/problems/sliding-window-maximum/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }
}
