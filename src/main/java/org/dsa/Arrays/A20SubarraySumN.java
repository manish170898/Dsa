package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//Given an unsorted array of integers, find the number of subarrays having a sum exactly equal to a given number k.
//
//        Examples:
//
//        Input : arr[] = {10, 2, -2, -20, 10}, k = -10
//        Output : 3
//        Explanation: Subarrays: arr[0…3], arr[1…4], arr[3..4] have a sum exactly equal to -10.
//
//        Input : arr[] = {9, 4, 20, 3, 10, 5}, k = 33
//        Output : 2
//        Explanation: Subarrays : arr[0…2], arr[2…4] have a sum exactly equal to 33.
public class A20SubarraySumN {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{1,2,3,4}; int k = 4;
        System.out.println(subarraySum(arr, k));
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0;
        map.put(sum,1);
        int ans = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum = sum + nums[i];
            if(map.containsKey(sum-k)){
                int count = map.get(sum-k);
                ans += count;
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum) + 1);
            }
            else{
                map.put(sum,1);
            }
        }
        return ans;
    }
}
