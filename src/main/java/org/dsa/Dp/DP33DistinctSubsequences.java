package org.dsa.Dp;

import java.util.Arrays;

public class DP33DistinctSubsequences {
//    https://leetcode.com/problems/distinct-subsequences/
    public int numDistinctRec(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        int[][] dp = new int[lenS][lenT];

        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return recRec(s,t,lenS-1,lenT-1,dp);
    }

    int recRec(String s, String t, int indS, int indT, int[][] dp){
        if(indT <0 ) return 1;
        else if(indS < 0) return 0;

        if(dp[indS][indT] != -1) return dp[indS][indT];

        if(s.charAt(indS) == t.charAt(indT)){
            return dp[indS][indT] = recRec(s, t, indS-1, indT-1, dp) + recRec(s,t, indS-1, indT, dp);
        }
        else{
            return dp[indS][indT] = recRec(s,t,indS-1, indT,dp);
        }
    }

    public int numDistinctTab(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        int[][] dp = new int[lenS+1][lenT+1];

        for(int i=0; i<=lenS; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j<=lenT; j++){
            dp[0][j] = 0;
        }
        for(int indS = 1; indS <= lenS; indS++){
            for(int indT = 1; indT <= lenT; indT++){
                if(s.charAt(indS-1) == t.charAt(indT-1)){
                    dp[indS][indT] = dp[indS-1][indT-1] + dp[indS-1][indT];
                }
                else{
                    dp[indS][indT] = dp[indS-1][indT];
                }
            }
        }
        return dp[lenS][lenT];
    }
}

