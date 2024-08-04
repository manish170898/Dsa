package org.dsa.Dp;

import java.util.Arrays;

public class D15SubsetSumEqualToK {
//    https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
    static int[][] dp ;
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        dp = new int[n][k+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return (subsetSumToKRec(0, n, k, arr, 0) == 1);
    }

    public static int subsetSumToKRec(int index, int n, int k, int[] arr, int sum) {
        if (index >= n) {
            if (sum == k)
                return 1;
            else
                return 0;
        }
        if (sum > k)
            return 0;
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int t = subsetSumToKRec(index + 1, n, k, arr, sum + arr[index]);
        dp[index][sum] = t;
        if (t == 1) return 1;
        t = subsetSumToKRec(index + 1, n, k, arr, sum);
        dp[index][sum] = t;
        if (t == 1) return 1;
        return 0;
    }

    public static void main(String[] args) {

        int n = 6, k = 10;
        int[] arr = {5, 2, 3, 10, 6, 8};
        System.out.println(subsetSumToKTab(n, k, arr));
//        4 4
//        6 1 2 1
//        5 6
//        1 7 2 9 10
    }
    public static boolean subsetSumToKTab(int n, int k, int[] arr){
        // Write your code here.
        boolean[][] dp = new boolean[n][k+1];
        for(boolean[] d: dp){
            Arrays.fill(d, false);
        }
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }


        int sum =0 ;
        for(int i=1; i<n; i++){
            for(int target = 1; target <= k; target ++){
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(arr[i] <= target)
                    take = dp[i-1][target - arr[i]];

                dp[i][target] = take || notTake;
                if(target == k && dp[i][target] == true){
                    return true;
                }
            }
        }
        return false;
    }
}
