package org.dsa.String;

import java.util.Stack;

public class S2MaximumNestingDepthoftheParentheses {
//    https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
    public int maxDepth(String s) {
        int count =0;
        int currCount=0;
        Stack<Character> stack= new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
                currCount ++;
            }
            else if(c == ')'){
                stack.pop();
                currCount --;
            }
            count = Math.max(count, currCount);
        }
        return count;
    }
}
