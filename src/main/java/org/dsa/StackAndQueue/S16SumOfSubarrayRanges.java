package org.dsa.StackAndQueue;

import java.util.Stack;

public class S16SumOfSubarrayRanges {
//    https://leetcode.com/problems/sum-of-subarray-ranges/

    public static void main(String[] args) {
        S16SumOfSubarrayRanges sum = new S16SumOfSubarrayRanges();
        int[] nums = new int[]{1,2,3};
        sum.subArrayRanges(nums);
    }

    public long subArrayRanges(int[] nums) {
        return sumOfSubarrayMax(nums) - sumOfSubarrayMin(nums);
    }

    public long sumOfSubarrayMax(int[] nums){
        int n = nums.length;
        int[] prevGreaterElement = new int[n];
        int[] nextGreaterElement = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            prevGreaterElement[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            nextGreaterElement[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long result = 0;
        for(int i=0; i<n; i++){
            result += (long) (i-prevGreaterElement[i]) * (nextGreaterElement[i] - i) * nums[i];
        }
        return result;
    }

    public long sumOfSubarrayMin(int[] nums){
        int n = nums.length;
        int[] prevSmallerElement = new int[n];
        int[] nextSmallerElement = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            prevSmallerElement[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            nextSmallerElement[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long result = 0;
        for(int i=0; i<n; i++){
            result += (long) (i-prevSmallerElement[i]) * (nextSmallerElement[i] - i) * nums[i];
        }
        return result;
    }
}

