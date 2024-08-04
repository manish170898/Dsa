package org.dsa.StackAndQueue;

import java.util.Stack;

public class S14NearestSmallerElement {
//    https://www.interviewbit.com/problems/nearest-smaller-element/
    public int[] prevSmaller(int[] A) {
        int[] ans = new int[A.length];
        Stack<Integer> st= new Stack<>();

        for(int index= 0; index<A.length; index++){
            while(!st.isEmpty() && st.peek() >= A[index]) st.pop();
            if(st.isEmpty()){
                ans[index] = -1;
            }
            else{
                ans[index] = st.peek();
            }
            st.push(A[index]);
        }
        return ans;
    }
}
