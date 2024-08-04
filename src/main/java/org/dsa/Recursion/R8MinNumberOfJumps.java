package org.dsa.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Given an array arr[] where each element represents the max number of steps that can be made forward from that index. The task is to find the minimum number of jumps to reach the end of the array starting from index 0.
//
//        Examples:
//
//        Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
//        Output: 3 (1-> 3 -> 9 -> 9)
//        Explanation: Jump from 1st element to 2nd element as there is only 1 step.
//        Now there are three options 5, 8 or 9. If 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.
//
//        Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//        Output: 10
//        Explanation: In every step a jump is needed so the count of jumps is 10.

public class R8MinNumberOfJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(n==1){
            System.out.println(0);
        }
        if(arr[0] == 0){
            System.out.println("Unreachable");
        }
        int steps = arr[0];
        int maxReach = arr[0];
        int jumps=1;

        for(int i=1; i<n; i++){
            if(i == n-1){
                System.out.println(jumps);
            }

            maxReach =Math.max(maxReach, i+arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if(i >= maxReach){
                    System.out.println("Unreachable");
                }
                steps = maxReach -i;
            }
        }
        System.out.println("Unreachable");
    }
}
