package org.dsa.String;

import java.util.Stack;

public class S10RemoveOutermostParentheses {
//    https://leetcode.com/problems/remove-outermost-parentheses/description/
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                if(!st.isEmpty()){
                    sb.append(s.charAt(i));
                    st.push('(');
                }
                else st.push('(');
            }
            else if(s.charAt(i) == ')'){
                if(st.size() == 1){
                    st.pop();
                }
                else{
                    sb.append(s.charAt(i));
                    st.pop();
                }
            }
        }
        return sb.toString();
    }
}
