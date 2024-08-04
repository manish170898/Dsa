package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//Input:
//        V1 = “1.0.31”
//        V2 = “1.0.27”
//        Output:  v1 is latest
//        Because V2 < V1
//Input:
//        V1 = “1.0.10”
//        V2 = “1.0.27”
//        Output:  v2 is latest
//        Because V1 < V2

public class A11CompareVersionNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String v1 = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String v2 = st.nextToken();

        String[] arr = v1.split("\\.",0);
        String[] arr1 = v2.split("\\.",0);

        for(int i=0; i< Math.min(arr1.length, arr.length); i++){
            if(Integer.parseInt(arr[i]) < Integer.parseInt(arr1[i])){
                System.out.println(-1);
                break;
            }
            else if(Integer.parseInt(arr[i]) > Integer.parseInt(arr1[i])){
                System.out.println(1);
                break;
            }
        }
        if(arr.length < arr1.length){
            for(int i = arr.length; i < arr1.length; i++){
                if(Integer.parseInt(arr1[i]) != 0){
                    System.out.println(-1);
                    break;
                }
            }
        }
        else{
            for(int i = arr1.length; i < arr.length; i++){
                if(Integer.parseInt(arr[i]) != 0){
                    System.out.println(1);
                    break;
                }
            }
        }
        // if none of the above passes
        System.out.println(0);
    }
}
