package org.dsa.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class S15SumOfSubarrayMinimums {
//    https://leetcode.com/problems/sum-of-subarray-minimums/description/

    public static void main(String[] args) {

    }
    public int sumSubarrayMins(int[] arr) {
        int[] nextSmallerIndex = new int[arr.length];
        int[] prevSmallerIndex = new int[arr.length];

        Stack<Integer> st = new Stack();

        Arrays.fill(prevSmallerIndex, -1);
        Arrays.fill(nextSmallerIndex, arr.length);
//        For ever element here we find out in how many subarrays will it me min on left and how many in right
//        and multiply those values .. that will be the total subarrays in which they will be minimum
//        if we multiple the number of times the element will be minimum to the individual element we will get the ans for each element .. then sum all of that to gget final asnwer


        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevSmallerIndex[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextSmallerIndex[i] = st.peek();
            }
            st.push(i);
        }

        int mod = (int) 1e9 + 7;
        long result = 0;

        for(int i=0; i<arr.length; i++){
            result += (long) (i-prevSmallerIndex[i]) * (nextSmallerIndex[i] - i) % mod * arr[i] % mod ;
            result %= mod;
        }

        return (int) result;
    }
}
