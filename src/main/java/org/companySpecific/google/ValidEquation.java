package org.companySpecific.google;

import java.util.Stack;

public class ValidEquation {
    public static void main(String[] args) {
        String eq = "+ a + --x = a + b";
        System.out.println(isValid(eq));
    }
    public static boolean isValid(String eq) {
        int n = eq.length();
        Stack<Character> st = new Stack<>();

        for (int i=0; i<n; ++i) {
            char c = eq.charAt(i);
            if(c == ' ') {
                continue;
            }
            if(c == ')') {
                StringBuilder shortEquation = new StringBuilder();
                while(!st.isEmpty() && st.peek()!='(') {
                    shortEquation.append(st.peek());
                    st.pop();
                }
                if(st.isEmpty())
                    return false;
                st.pop();
                boolean valid = isValid(shortEquation.toString());
                if(!valid)
                    return valid;
                st.push('a');
            }
            else
                st.push(c);
        }
        int i=0;
        while(!st.isEmpty()) {
            char top = st.pop();
            if(i%2 == 0) {
                if(top < 'a' || top > 'z')
                    return false;
            }
            else {
                if(top != '+' && top != '-' && top != '/' && top != '=')
                    return false;
            }
            ++i;
        }

        return true;
    }

}
