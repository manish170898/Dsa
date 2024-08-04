package org.companySpecific.google;

import java.util.Arrays;

public class SortPartiallySortedArray {
    public static void main(String[] args) {
        int[] arr = {9,8,1,4,6,100207, 100205, 100204, 100206, 100203};
        sortArr(arr);
        for(int i=0; i<arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void  sortArr(int[] arr) {
        int n = arr.length;
        if(n<=1)
            return;
        int start = 0;
        int end = 1;
        while(end<n) {
            if((arr[end] & ~15) != (arr[end-1] & ~15) ) {
                sortSubArr(arr, start, end);
                start = end;
            }
            ++end;
        }
        sortSubArr(arr, start, end);
    }

    private static void sortSubArr(int[] arr, int start, int end) {
        Arrays.sort(arr, start, end);
    }
}
