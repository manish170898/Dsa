package org.dsa.Dp;

import java.util.Arrays;
//https://leetcode.com/problems/edit-distance/description/
public class DP34EditDistance {
    public int minDistanceRec(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1][len2];

        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        return rec(word1, word2, len1-1, len2-1, dp);
    }

    int rec(String word1, String word2, int ind1, int ind2, int[][] dp){
        if(ind1 < 0) return ind2+1;
        if(ind2 < 0) return ind1+1;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(word1.charAt(ind1) == word2.charAt(ind2)) {
            return dp[ind1][ind2] = rec(word1, word2, ind1-1, ind2-1, dp);
        }
        else{
            int insert = 1 + rec(word1, word2, ind1, ind2-1, dp);
            int del = 1 + rec(word1, word2, ind1-1, ind2, dp);
            int replace = 1 + rec(word1, word2, ind1-1, ind2-1, dp);

            return dp[ind1][ind2] = Math.min(insert, Math.min(del, replace));
        }
    }

    public int minDistanceTab(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=0; i<=len1; i++){
            dp[i][0] = i;
        }

        for(int j=0; j<=len2; j++){
            dp[0][j] = j;
        }

        for(int ind1=1; ind1<=len1; ind1++){
            for(int ind2=1; ind2<=len2; ind2++){
                if(word1.charAt(ind1-1) == word2.charAt(ind2-1)) {
                    dp[ind1][ind2] = dp[ind1-1][ind2-1];
                }
                else{
                    int insert = dp[ind1-1][ind2];
                    int del = dp[ind1][ind2-1];
                    int replace = dp[ind1-1][ind2-1];

                    dp[ind1][ind2] = 1 + Math.min(insert, Math.min(del, replace));
                }
            }
        }
        return dp[len1][len2];
    }

}
