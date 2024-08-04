package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9RearrangeNegativePositive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer n = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        orderDiesNotMatter(arr, n);
//        orderMatter(arr, n);
    }

    private static void orderMatter(Integer[] arr, Integer n) {

    }

    private static void orderDiesNotMatter(Integer[] arr, Integer n) {
        int i=0, j=n-1;
        while(i<j){
            if(arr[j]<0){
                j--;
            }
            if(arr[i]>=0){
                i++;
            }
            else{
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                j--;
            }
        }
        for(int k=0; k<n; k++){
            System.out.print(arr[k] + " ");
        }
        if(i==0 || i==n){
            System.out.println("Sorted");
        }
        // Not completetly implemented

        j=0;
        while(i<n){
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
            i++;
            j+=2;
        }
        for(int k=0; k<n; k++){
            System.out.print(arr[k]);
        }
    }
}
