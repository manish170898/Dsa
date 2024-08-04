package org.dsa.Arrays;

public class A3NumberAppearsOnlyOnce {

    public static Integer singleNumber(int[] arr){
        int xor = 0;
        for (int i=0; i<= arr.length-1; i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }
}
