package org.dsa.Recursion;

import java.util.Stack;

public class R9ReverseStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        reverseStack(st);
    }
    public static void reverseStack(Stack<Integer> stack) {
        // write your code here
        if(stack.isEmpty()){
            return;
        }
        int popped = stack.pop();
        reverseStack(stack);
        pushAtBottom(popped, stack);
    }

    public static void pushAtBottom(int element, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(element);
            return;
        }
        int popped = st.pop();
        pushAtBottom(element, st);
        st.push(popped);
    }
}
