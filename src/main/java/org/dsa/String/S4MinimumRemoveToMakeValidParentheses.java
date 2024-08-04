package org.dsa.String;

import java.util.Stack;

public class S4MinimumRemoveToMakeValidParentheses {
//    https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
    public String minRemoveToMakeValid(String s) {
        // Convert input string to character array for easier manipulation
        char[] arr = s.toCharArray();
        Stack<Integer> st = new Stack<>();

        // inset index of opening  and closing paranthesis in stack, also pop if valid paranthesis found.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                st.push(i);
            else if (arr[i] == ')') {
                if (!st.isEmpty() && arr[st.peek()] == '(')
                    st.pop();
                else
                    st.push(i);
            }
        }

        // traverse from end as stack has end index at top .. skip the indexes in stack .. and form string then reverse it and thats your answer
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if(!st.isEmpty() && st.peek() == i){
                st.pop();
            }
            else{
                sb.append(arr[i]);
            }
        }

        return sb.reverse().toString();
    }
}
