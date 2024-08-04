package org.dsa.Dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D13MinimumFallingPathSum {
//    https://leetcode.com/problems/minimum-falling-path-sum/
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        if(n == 1){
            return matrix[0][0];
        }
        for(int i=0; i<n; i++){
            dp[0][i] = matrix[0][i];
        }
        int ans = Integer.MAX_VALUE;
        int[] nRow = {-1, -1, -1};
        int[] nCol = {-1, 0, 1};
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int min = Integer.MAX_VALUE;
                for(int k =0; k<3; k++){
                    int row = i + nRow[k];
                    int col = j + nCol[k];
                    if(row>= 0 && col >=0 && row<n && col<n){
                        min = Math.min(min, dp[row][col]);
                    }
                }
                dp[i][j] = min + matrix[i][j];
                if(i == n-1){
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
