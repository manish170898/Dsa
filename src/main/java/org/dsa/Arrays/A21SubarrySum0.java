package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A21SubarrySum0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Integer arr[] = new Integer[T];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<T; i++){
            sum= sum+arr[i];
            if(set.contains(sum)){
                System.out.println("True");
                break;            }
            else {
                set.add(sum);
            }
        }

    }
}
