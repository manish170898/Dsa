package org.dsa.Dp;

public class DP29LongestPalindromicSubsequence {
//    https://leetcode.com/problems/longest-palindromic-subsequence/description/

    public static void main(String[] args) {
        // Can be converted to Longest Common Subsequence which is DP26 ... we need to find LCS of s and reverse(s) .. that will be Longest Palindromic Subsequence
    }

    public int longestPalindromeSubseq(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        return longestCommonSubseq(s, reverseS);
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
