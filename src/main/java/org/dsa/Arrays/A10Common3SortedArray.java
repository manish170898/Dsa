package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

//Input:
//        ar1[] = {1, 5, 10, 20, 40, 80}
//        ar2[] = {6, 7, 20, 80, 100}
//        ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
//        Output: 20, 80
//
//        Input:
//        ar1[] = {1, 5, 5}
//        ar2[] = {3, 4, 5, 5, 10}
//        ar3[] = {5, 5, 10, 20}
//        Output: 5, 5

public class A10Common3SortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Integer arr[] = new Integer[T];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T1 = Integer.parseInt(st.nextToken());
        Integer arr1[] = new Integer[T1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T2 = Integer.parseInt(st.nextToken());
        Integer arr2[] = new Integer[T2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        if((arr[0] > arr1[T1-1] || arr[0] > arr2[T2-1]) ||
                (arr1[0] > arr[T-1] || arr1[0] > arr2[T2-1]) ||
                (arr2[0] > arr[T-1] || arr2[0] > arr1[T1-1])){
            System.out.println(-1);
        }

        ArrayList<Integer> result= new ArrayList<>();
        int i=0;
        int j=0;
        int k=0;
        while(i<T && j<T1 && k<T2){
            if(Objects.equals(arr[i], arr1[j]) && Objects.equals(arr1[j], arr2[k])){

                result.add(arr[i]);
                i++;
                j++;
                k++;

            }
            else{
                if(arr[i] < arr1[j] || arr[i] < arr2[k]){
                    i++;
                }
                if(arr1[j] < arr[i] || arr1[j] < arr2[k]){
                    j++;
                }
                if(arr2[k] < arr1[j] || arr2[k] < arr[i]){
                    k++;
                }
            }
        }
        if(result.isEmpty()){
            System.out.println(-1);
        }
        List<Integer> list = result.stream().distinct().collect(Collectors.toList());
        for(Integer nm : list){
            System.out.println(nm);
        }
    }
}
