package org.dsa.Dp;

public class DP32ShortestCommonSupersequence {
    // If we want just the length of subsequence that is straightforward
    // get the longest common subsequence and answer will be ans = m + n - lcs;
    // that will be the shortest common super sequence

    // but we need to print the shortest common supersequence
    // we will modify the printing algo we used in print longest common subsequence

//    https://leetcode.com/problems/shortest-common-supersequence/description/

    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1+1][len2+1];

        for(int ind1=1; ind1<=len1; ind1++){
            for(int ind2=1; ind2<=len2; ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = len1;
        int j = len2;

        while(i!=0 && j!=0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                ans.append(str1.charAt(i-1));
                i--;
            }
            else{
                ans.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i!=0){
            ans.append(str1.charAt(i-1));
            i--;
        }
        while(j!=0){
            ans.append(str2.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();
    }
}
