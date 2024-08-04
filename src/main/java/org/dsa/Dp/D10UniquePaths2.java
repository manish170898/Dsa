package org.dsa.Dp;

public class D10UniquePaths2 {
//    https://leetcode.com/problems/unique-paths-ii/description/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        dp[0][0] = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int nRow = i-1;
                int nCol = j-1;
                if(obstacleGrid[i][j] == 0){
                    if(nRow >=0 && nRow < m){
                        dp[i][j] += dp[nRow][j];
                    }
                    if(nCol >=0 && nCol < n){
                        dp[i][j] += dp[i][nCol];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}
