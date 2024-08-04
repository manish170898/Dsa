package org.dsa.Dp;

public class D9UniquePaths {
//    https://leetcode.com/problems/unique-paths/description/
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int nRow = i-1;
                int nCol = j-1;
                if(nRow >=0 && nRow < m){
                    dp[i][j] += dp[nRow][j];
                }
                if(nCol >=0 && nCol < n){
                    dp[i][j] += dp[i][nCol];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
