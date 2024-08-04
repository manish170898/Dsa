package org.dsa.Graph;

public class G55FindMaximumSumNodeValues {
    public static void main(String[] args) {
        int[]nums =  {7,7,7,7,7,7};
        long k=1000000000;
        int[][] edges = {{0,1},{0,2},{0,3},{0,4},{0,5}};

    }
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        int count = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            if((n^k) > n){
                sum += n^k;
                count++;
                min = Math.min(min, (n^k) - n);
            }
            else{
                sum+=n;
                min = Math.min(min, n - (n^k));
            }
        }
        if(count%2 != 0) sum -= min;
        return sum ;
    }
}
