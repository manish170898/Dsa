package org.dsa.Dp;

public class D11MinimumPathSum {
//    https://leetcode.com/problems/minimum-path-sum/description/
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j ==0){
                    continue;
                }
                int nRow = i-1;
                int nCol = j-1;
                int maxLeft = Integer.MAX_VALUE, maxDown = Integer.MAX_VALUE;
                if(nRow >=0 && nRow < m){
                    maxDown = dp[nRow][j];
                }
                if(nCol >=0 && nCol < n){
                    maxLeft = dp[i][nCol];
                }
                dp[i][j] = grid[i][j] + Math.min(maxDown, maxLeft);
            }
        }

        return dp[m-1][n-1];
    }
}
