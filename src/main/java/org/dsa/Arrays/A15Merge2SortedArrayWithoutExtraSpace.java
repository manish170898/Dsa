package org.dsa.Arrays;

import java.util.stream.Collectors;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

//Input: ar1[] = {10}, ar2[] = {2, 3}
//        Output: ar1[] = {2}, ar2[] = {3, 10}
//
//        Input: ar1[] = {1, 5, 9, 10, 15, 20}, ar2[] = {2, 3, 8, 13}
//        Output: ar1[] = {1, 2, 3, 5, 8, 9}, ar2[] = {10, 13, 15, 20}
public class A15Merge2SortedArrayWithoutExtraSpace {
    public static void main(String[] args){

        Integer[] arr1 = {1, 3, 5, 7};
        Integer[] arr2 = {0, 2, 6, 8, 9};

        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0, k = n - 1;
        while (i <= k && j < m) {
            if (arr1[i] < arr2[j])
                i++;
            else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        sort(arr1);
        sort(arr2);

        System.out.println(stream(arr1).collect(Collectors.toList()));
        System.out.println(stream(arr2).collect(Collectors.toList()));
    }
}
