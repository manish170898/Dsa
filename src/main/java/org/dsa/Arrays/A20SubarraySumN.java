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
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int T = Integer.parseInt(st.nextToken());
//        Integer arr[] = new Integer[T];
//        st = new StringTokenizer(br.readLine());
//        int S = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<T; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
        int sum=0;
//        Set<Integer> list = new HashSet<>();
//        for(int i=0; i<T; i++){
//            sum= sum+arr[i];
//            if(sum-S>0){
//                if(list.contains(sum-S)){
//                    System.out.println("True");
//                    break;
//                }
//            }
//            else {
//                list.add(sum);
//            }
//        }
        int[] arr = {10, 2, -2, -20, 10};
        int T=5;
        int S =-10;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(sum,0);
        for(int i=0; i<T; i++){
            sum= sum+arr[i];
            if(sum-S >= 0){
                if(map.containsKey(sum-S)){
                    System.out.println(i+1);
                    System.out.println(map.get(sum-S)+1);
                    break;
                }
            }
            map.put(sum,i+1);
        }
    }
}
