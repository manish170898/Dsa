package org.dsa.String;

import java.util.Stack;

public class S3MakeTheStringGreat {

//    https://leetcode.com/problems/make-the-string-great/?envType=daily-question&envId=2024-04-05
    public String makeGood(String s) {
        if(s.equals("")) return s;
        Stack<Character> st = new Stack<>();
        char[] sArr = s.toCharArray();
        int i=0;
        while(i < sArr.length){
            if(!st.isEmpty() && Math.abs((sArr[i]-st.peek())) == 32){
                st.pop();
            }
            else{
                st.push(sArr[i]);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
