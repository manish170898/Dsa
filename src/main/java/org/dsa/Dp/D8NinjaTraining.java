package org.dsa.Dp;

import java.util.Arrays;

public class D8NinjaTraining {
//    https://www.naukri.com/code360/problems/ninja%E2%80%99s-training_3621003?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
    public static int ninjaTraining(int n, int[][] points) {
        // Write your code here..
        int[][] dp = new int[points.length][points[0].length];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        int max = 0;
        for(int i=0; i<2; i++){
            max = Math.max(max, recNinja(points.length-1, i, points, dp));
        }
        return max;
    }

    public static int recNinja(int index, int col, int[][] points, int[][] dp){
        if(index == 0){
            int zMax = 0;
            for(int i=0; i<3; i++){
                if(i != col){
                    zMax = Math.max(points[index][i], zMax);
                }
            }
            return zMax;
        }
        if(dp[index][col] != -1){
            return dp[index][col];
        }
        int max = 0;
        for(int i=0; i<3; i++){
            if(i != col){
                int pick = points[index][i] +recNinja(index-1, i, points, dp) ;
                max = Math.max(pick, max);
            }
        }
        return dp[index][col]=max;
    }

    public static int ninjaTrainingTabulation(int n, int[][] points) {
        // Write your code here..
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[points.length][points[0].length];
        for(int i=0; i<points[0].length; i++){
            dp[0][i] = points[0][i];
        }

        for(int i=1; i<points.length; i++){
            for(int j=0; j< points[0].length;j++){
                int max = Integer.MIN_VALUE;
                for(int k=0; k<points[0].length; k++){
                    if(k!=j){
                        max = Math.max(max, points[i][j] + dp[i-1][k]);
                    }
                }
                dp[i][j] = max;
                if(i == points.length-1){
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
