package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// longest subarray with atmost k even elements ...

public class LongestSubarrayAtmostKElemnts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n = 0,k=0;
        while(t>0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            Integer[] arr = new Integer[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int initial=0, last=0;
            int longest=0;
            while(last<n){
                if(arr[last]%2 == 0){
                    k--;
                }
                if(k!=-1){
                    last++;
                }
                else{
                    if(longest < (last-initial)){
                        longest = last-initial;
                    }
                    if(arr[initial]%2 == 0){
                        k++;
                    }
                    initial++;
                }
                if(last == n && longest == 0){
                    longest = last-initial;
                }
            }
            System.out.println(longest);
            t--;
        }
    }
}
