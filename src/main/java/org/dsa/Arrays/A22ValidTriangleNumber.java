package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Given an unsorted array of positive integers, find the number of triangles that can be formed with three different array elements as three sides of triangles.
// For a triangle to be possible from 3 values, the sum of any of the two values (or sides) must be greater than the third value (or third side).
//
//        Examples:
//
//        Input: arr= {4, 6, 3, 7}
//        Output: 3
//        Explanation: There are three triangles
//        possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}.
//        Note that {3, 4, 7} is not a possible triangle.
//
//        Input: arr= {10, 21, 22, 100, 101, 200, 300}.
//        Output: 6
//        Explanation: There can be 6 possible triangles:
//        {10, 21, 22}, {21, 100, 101}, {22, 100, 101},
//        {10, 100, 101}, {100, 101, 200} and {101, 200, 300}


//Input: nums = [2,2,3,4]
//        Output: 3
//        Explanation: Valid combinations are:
//        2,3,4 (using the first 2)
//        2,3,4 (using the second 2)
//        2,2,3


public class A22ValidTriangleNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());
        Integer[] nums = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int n = nums.length;   // 4
        int c;
        int count=0;
        for(int j=n-1; j>=2; j--){   // 3
            c=nums[j];
            int k=0;      // 0
            int i=j-1;    // 2
            while(k<i){
                if(nums[i] + nums[k] > c){
                    count = count + (i-k);
                    i--;
                }
                else{
                    k++;
                }
            }
        }
        System.out.println(count);
    }
}

//   2 2 3 4
//   0 1 2 3