package org.dsa.Dp;

import java.util.Arrays;

public class D14ChocolatePickup {
//    https://www.naukri.com/code360/problems/chocolate-pickup_3125885?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
    private static int[][][] dp;

    // MEMOIZATION
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        dp = new int[r][c][c];
        for(int[][] dc : dp){
            for(int[] d : dc){
                Arrays.fill(d, -1);
            }
        }
        return recChocPickup(0, 0, c-1, grid, r, c);
    }


    public static int recChocPickup(int index, int aliceIndex, int bobIndex, int[][] grid, int r, int c){
        if(index == r){
            return 0;
        }
        int[] col = {-1, 0, 1};
        int nRow = index+1;
        int max = Integer.MIN_VALUE;
        if(dp[index][aliceIndex][bobIndex] != -1){
            return dp[index][aliceIndex][bobIndex];
        }
        for(int alice=0; alice<3; alice++){
            for(int bob=0; bob<3; bob++){
                int nColAlice = aliceIndex + col[alice];
                int nColBob = bobIndex + col[bob];
                if(nColAlice >= 0 && nColAlice < c && nColBob >= 0 && nColBob < c && nRow<= r && nColAlice != nColBob){
                    max = Math.max(grid[index][aliceIndex] + grid[index][bobIndex] + recChocPickup(nRow, nColAlice, nColBob, grid, r, c), max);
                }
            }
        }
        return dp[index][aliceIndex][bobIndex] = max;
    }

    public static void main(String[] args) {
        int r = 3 , c=4;
        int[][] grid = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
        maximumChocolatesTab(r, c, grid);

    }
    public static int maximumChocolatesTab(int r, int c, int[][] grid) {
        // Write your code here.
        dp = new int[r][c][c];
        for(int[][] dc : dp){
            for(int[] d : dc){
                Arrays.fill(d, -1);
            }
        }
        dp[0][0][c-1] = grid[0][0] + grid[0][c-1];

        int[] col = {-1, 0, 1};

        int ans = Integer.MIN_VALUE;

        //Loop for Index
        for(int i=1; i< r; i++){
            //Position Of alice
            for(int alice=0; alice<c; alice++){
                //Position Of bob
                for(int bob=0; bob<c; bob++){
                    int max = Integer.MIN_VALUE;
                    //Positions from which alice can come
                    for(int a=0; a<3; a++){
                        //Positions from which bob can come
                        for(int b= 0; b<3; b++){
                            int nColAlice = alice + col[a];
                            int nColBob = bob + col[b];
                            if(nColAlice >= 0 && nColAlice < c && nColBob >= 0 && nColBob < c  && dp[i-1][nColAlice][nColBob] != -1 && alice != bob){
                                max = Math.max(grid[i][alice] + grid[i][bob] + dp[i-1][nColAlice][nColBob], max);
                            }
                        }
                    }
                    dp[i][alice][bob] = max;
                    if(i == r-1){
                        ans = Math.max(ans, dp[i][alice][bob]);
                    }
                }
            }
        }
        return ans;
    }
}
