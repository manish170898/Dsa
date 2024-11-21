package org.dsa.Dp;

import java.util.Arrays;
//https://leetcode.com/problems/wildcard-matching/description/

public class DP35WildcardMatching {
    public boolean isMatchRec(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        int[][] dp = new int[lenS][lenP];

        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        if(rec(lenS-1, lenP-1, s, p, dp) == 1) return true;
        return false;
    }

    int rec(int indS, int indP, String s, String p, int[][] dp){
        if(indP<0 && indS<0) {
            return 1;
        }
        else if(indP<0 && indS>=0){
            return 0;
        }
        else if(indP>=0 && indS<0){
            for(int i=0; i<= indP; i++){
                if(p.charAt(i) != '*') return 0;
            }
            return 1;
        }
        if(dp[indS][indP] != -1) return dp[indS][indP];

        if(s.charAt(indS) == p.charAt(indP) || p.charAt(indP) == '?'){
            return dp[indS][indP] = rec(indS-1, indP-1, s, p, dp);
        }
        else if(p.charAt(indP) == '*'){
            if(rec(indS-1, indP, s, p, dp) == 1 || rec(indS, indP-1, s, p, dp) == 1) return dp[indS][indP] = 1;
            else return dp[indS][indP] = 0;
        }
        else{
            return dp[indS][indP] = 0;
        }
    }

    public boolean isMatchTAb(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        boolean[][] dp = new boolean[lenS+1][lenP+1];

        for(int i=1; i<=lenS; i++){
            dp[i][0] = false;
        }
        for(int i=1; i<=lenP; i++){
            boolean flag = true;
            for(int ii=1; ii<=i; ii++){
                if(p.charAt(ii-1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[0][i] = flag;
        }
        dp[0][0] = true;

        for(int indS=1; indS<=lenS; indS++){
            for(int indP=1; indP<=lenP; indP++){
                if(s.charAt(indS-1) == p.charAt(indP-1) || p.charAt(indP-1) == '?'){
                    dp[indS][indP] = dp[indS-1][indP-1];
                }
                else if(p.charAt(indP-1) == '*'){
                    dp[indS][indP] = dp[indS-1][indP] || dp[indS][indP-1];
                }
                else{
                    dp[indS][indP] = false;
                }
            }
        }

        return dp[lenS][lenP];
    }
}
