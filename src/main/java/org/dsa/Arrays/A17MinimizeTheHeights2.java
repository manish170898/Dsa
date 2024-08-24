package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



//Given an array arr[] denoting heights of N towers and a positive integer K.
//
//        For each tower, you must perform exactly one of the following operations exactly once.
//
//        Increase the height of the tower by K
//        Decrease the height of the tower by K
//        Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.
//
//        You can find a slight modification of the problem here.
//        Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.
//
//        Example 1:
//
//        Input:
//        K = 2, N = 4
//        Arr[] = {1, 5, 8, 10}
//        Output:
//        5
//        Explanation:
//        The array can be modified as
//        {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.
//        The difference between
//        the largest and the smallest is 8-3 = 5.

public class A17MinimizeTheHeights2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Integer n = Integer.parseInt(st.nextToken());
//        Integer k = Integer.parseInt(st.nextToken());

//        Integer[] arr = new Integer[n];
//        st = new StringTokenizer(br.readLine());
//
//        for(int i=0; i<n; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
        int n=4; int k=2;
        int[] arr = {10,10,10,10};

        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[n-1] - k;
        int mi, ma;
        for(int i=0; i<n-1; i++){
            mi = Math.min(smallest, arr[i+1] - k);
            ma = Math.max(largest, arr[i] + k);
            if(mi < 0){
                continue;
            }
            ans = Math.min(ans, ma-mi);
        }
        System.out.println(ans);
    }
}
