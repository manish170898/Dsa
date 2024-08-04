package org.dsa.Dp;

public class D19PartitionsWithGivenDifference {

//    we have to calculateee S1-S2 = D where S1> S2
//    Total SUm -S2 -S2 = D
//    Total Sum -2S2 = D
//    (TotalSum - D)/ 2 = S2
//    So question biols down to find count of subsets with sum S2 which is DP18
public static int countPartitions(int n, int d, int[] arr) {
    // code here
    int sum = 0;
    for(int num : arr){
        sum+=num;
    }
    int sumMinusD = (sum-d);
    if(sumMinusD % 2 != 0 || d > sum) return 0;

    int toBeCounted = sumMinusD/2;

    return perfectSum(arr, n, toBeCounted);
}

    public static int perfectSum(int arr[],int n, int sum)
    {
        int[][] dp = new int[n][sum+1];
        dp[0][0] = 1;
        if(arr[0] <= sum) dp[0][arr[0]]++;
        int MOD = (int)(1e9 +7);

        for(int i=1; i<n; i++){
            for(int s=0; s<=sum; s++){
                int notTake = dp[i-1][s];
                int take = 0;
                if(arr[i] <= s){
                    take = dp[i-1][s-arr[i]];
                }
                dp[i][s] = (take%MOD + notTake%MOD)%MOD;
            }
        }
        return dp[n-1][sum];
    }
}
