package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9sort0s1s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Integer arr[] = new Integer[T];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int j= T-1;
        int i=0;
        while (i<j){
            if(arr[i]==0){
                i++;
            }
            else{
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                j--;
            }
        }
        for(i=0; i<T; i++) {
            System.out.println(arr[i]);
        }
    }
}
