package org.dsa.Dp;

import java.util.List;

public class DP27PrintLongestCommonSubsequence {

    public List<String> all_longest_common_subsequences(String s, String t)
    {
        String text1 = s;
        String text2 = t;
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
        StringBuilder ans = new StringBuilder();
        int count = dp[text1.length()][text2.length()];
        int i = text1.length();
        int j = text2.length();
        while(i > 0 && j > 0 && count >0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ans.append(s.charAt(i-1));
                count--;
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]) i--;
                else j--;
            }
        }
        return List.of(ans.toString());
    }
}
