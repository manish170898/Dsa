package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A14KthLargestAndSmallest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer [] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        for(int i = k ; i < arr.length ; i++){
            if(arr[i] > pq.peek()){
                pq.add(arr[i]);
            }
        }
//        return pq.remove();
        System.out.println(pq.peek());
    }



    // FOR Kth smallest make Collections.reverseorder priority queue and check arr[i] < pq.peek rest same

}
