package org.dsa.StackAndQueue;

import java.util.Stack;

public class S18LargestRectangleInHistogram {
//    https://leetcode.com/problems/largest-rectangle-in-histogram/description/

//    (Next Smaller Index - Prev Smaller Index - 1) * arr[i] ... max of all will be answer ... O(3N) will be easy
//    doing it in 1 pass is most optimal solution

    public static void main(String[] args) {
       int[] heights = new int[] {9,0};
       S18LargestRectangleInHistogram s = new S18LargestRectangleInHistogram();
       s.largestRectangleArea(heights);
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];

        if(n==1) return heights[0];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>0; i--){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int result = 0;
        for(int i=0; i<n; i++){
            result = Math.max(result, (nse[i] - pse[i] -1) * heights[i]);
        }
        return result;
    }

    public int largestRectangleAreaOptimized(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        if(n==1) return heights[0];

        int result = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                Integer index = st.pop();
                result = Math.max(result, (i - pse[index] -1) * heights[index]);
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        while(!st.isEmpty()){
            Integer index = st.pop();
            result = Math.max(result, (n - pse[index] -1) * heights[index]);
        }
        return result;
    }
}
