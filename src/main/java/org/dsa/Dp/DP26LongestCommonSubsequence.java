package org.dsa.Dp;

import java.util.Arrays;

public class DP26LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return memoiz(text1.length()-1, text2.length()-1, text1, text2, dp);
    }

    public int memoiz(int index1, int index2, String text1, String text2, int[][] dp){
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        else if(text1.charAt(index1) == text2.charAt(index2)){
            return dp[index1][index2] =  1 + memoiz(index1-1, index2-1, text1, text2, dp);
        }
        else{
            return dp[index1][index2] = Math.max(memoiz(index1-1, index2, text1, text2, dp), memoiz(index1, index2-1, text1, text2, dp));
        }
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        longestCommonSubsequenceTab(text1, text2);
    }
    public static int longestCommonSubsequenceTab(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<text1.length(); i++){
            dp[i][0] =0;
        }
        for(int i=0; i<text2.length(); i++){
            dp[0][i] =0;
        }

        for(int i=1; i<=text1.length(); i++){
            for (int j=1; j<=text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
