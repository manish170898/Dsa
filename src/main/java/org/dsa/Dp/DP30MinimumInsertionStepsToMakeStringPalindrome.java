package org.dsa.Dp;

public class DP30MinimumInsertionStepsToMakeStringPalindrome {
    public static void main(String[] args) {
        // 2 step process
        // 1. Find out the longest Pallindromic subsequece
        // 2. Answer is n - longest Pallindromic Subsequnce
    }

//    https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

    public int minInsertions(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        int longestPallindromicSubsequence =  longestCommonSubseq(s, reverseS);
        return s.length() - longestPallindromicSubsequence;
    }

    int longestCommonSubseq(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1+1][len2+1];

        for(int ind1=1; ind1<=len1; ind1++){
            for(int ind2=1; ind2<=len2; ind2++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }

        return dp[len1][len2];
    }

}
