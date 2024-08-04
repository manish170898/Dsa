package org.dsa.Arrays;

import java.util.ArrayList;
import java.util.List;

public class A25UnionOfTwoSortedArrays {
    public static void main(String[] args) {

    }

    public Object[] union(int[] arr1, int[] arr2){
        int size1 = arr1.length;
        int size2 = arr2.length;

        List<Integer> union = new ArrayList<>();

        int j=0;
        int i=0;
        for (i=0; i<Math.min(arr1.length,arr2.length); i++){
            if(arr1[i] <= arr2[i]){
                if((union.get(j) != arr1[i]) || union.size() == 0){
                    union.add(j, arr1[i]);
                    j++;
                }
            }
            else if( union.get(j) != arr2[i] || union.size() == 0){
                union.add(j, arr2[i]);
                j++;
            }
        }

        if(i < size1){
            while (i< size1){
                if(union.get(j) != arr1[i] || union.size() == 0){
                    union.add(j, arr1[i]);
                    j++;
                }
                i++;
            }
        }
        if(i <size2) {
            while (i< size2){
                if(union.get(j) != arr2[i] || union.size() == 0){
                    union.add(j, arr2[i]);
                    j++;
                }
                i++;
            }
        }
        return  union.toArray();
    }
}
