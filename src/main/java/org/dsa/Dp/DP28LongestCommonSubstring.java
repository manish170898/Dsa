package org.dsa.Dp;

public class DP28LongestCommonSubstring {

    public static void main(String[] args) {

    }
//    https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

    public int longestCommonSubstrTabulation(String str1, String str2) {
        // code here
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1+1][len2+1];

        int ans = 0;

        for(int ind1=1; ind1<=len1; ind1++){
            for(int ind2=1; ind2<=len2; ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = 0;
                }
                ans = Math.max(ans, dp[ind1][ind2]);
            }
        }
        return ans;
    }
}
