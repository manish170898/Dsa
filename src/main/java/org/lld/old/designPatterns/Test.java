package org.lld.old.designPatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Integer arr[] = new Integer[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++){
                if(arr[j] >= arr[i]){
                    System.out.print(j+1 + " ");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.print(-1 + " ");
            }
            flag = false;
        }
    }

}