package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// KADANE's ALGORITHM

//Given an integer array nums, find the
//        subarray
//        with the largest sum, and return its sum.
//
//
//
//        Example 1:
//
//        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//        Example 2:
//
//        Input: nums = [1]
//        Output: 1
//        Explanation: The subarray [1] has the largest sum 1.
//        Example 3:
//
//        Input: nums = [5,4,-1,7,8]
//        Output: 23
//        Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

public class A8SubarrayMaxSumAndMinSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[T];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        minSum(arr);

        int size = arr.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        System.out.println(max_so_far);



    }

    private static void minSum(Integer[] arr) {
        int size = arr.length;
        int min_so_far = Integer.MAX_VALUE, min_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            min_ending_here = min_ending_here + arr[i];
            if (min_so_far > min_ending_here)
                min_so_far = min_ending_here;
            if (min_ending_here > 0)
                min_ending_here = 0;
        }
        System.out.println(min_so_far);
    }
}


// FOR SUBARRAY WITH MIN SUM

/*



 */
