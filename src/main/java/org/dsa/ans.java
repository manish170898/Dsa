package org.dsa;

import java.util.Arrays;

public class ans {
    public static void main(String[] args) {

//        int[] arr = {1,2,3};
//        int[] arr = {1};
//        int[] arr = {5,4,3};
//        int[] arr = {1,3,4};
        int[] arr = {10,9,8,7,6,5,4,3};

//        eg = [1,2,3,4] => [5, 6]
        System.out.println(Arrays.toString(missingIntegers(arr)));
    }

    public static int[] missingIntegers(int[] arr){
        int[] missing = new int[2];
        int missingLast =Integer.MAX_VALUE;
        int count = 0;
        int k=0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] != i+1){
                if(arr[i] <= n){
                    int temp = arr[i];
                    arr[i] = arr[arr[i]-1];
                    arr[temp-1] = temp;
                    i--;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i] != i+1){
                missing[k] = i+1;
                missingLast = arr[i];
                k++;
                count++;
            }
        }
        if(count == 0){
            missing[0] = n+1;
            missing[1] = n+2;
        }
        if(count ==1){
            if(missingLast == n+1) missing[1]=n+2;
            else missing[1] = n+1;
        }
        return missing;
    }
}
