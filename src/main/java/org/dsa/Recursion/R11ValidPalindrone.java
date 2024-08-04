package org.dsa.Recursion;

public class R11ValidPalindrone {
//    https://leetcode.com/problems/valid-palindrome/description/
    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        return rec(s.toCharArray(), 0, s.length()-1);
    }
    public static boolean rec(char[] s, int beg, int end){
        if(beg>=end){
            return true;
        }
        if(s[beg] != s[end]){
            return false;
        }
        if(rec(s, beg+1,end-1)) return true;
        return false;
    }
}
