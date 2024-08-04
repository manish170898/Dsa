package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
// Smallest possible number after removing k digits from a number
//Answer is Greedy Algorith... best possible decision at each step

//Input: num = "1432219", k = 3
//        Output: "1219"

//Given a string ‘str’ of digits and an integer ‘n’, build the lowest possible number by removing ‘n’ digits from the string and not changing the order of input digits.
//
//        Examples:
//
//        Input: str = "4325043", n = 3
//        Output: "2043"
//
//        Input: str = "765028321", n = 5
//        Output: "0221"
//
//        Input: str = "121198", n = 2
//        Output: "1118"

public class A19RemoveKdigits {
    public static void main(String[] args) throws IOException {
//        https://leetcode.com/problems/remove-k-digits/?envType=daily-question&envId=2024-04-11
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        if(k == num.length()){
            return "0";
        }

        int counter = 0;
        while(counter < num.length()){
            while(k >0 && !st.isEmpty() && st.peek() > num.charAt(counter)){
                st.pop();
                k--;
            }
            st.push(num.charAt(counter));
            counter++;
        }
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while (sb.length() >1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
