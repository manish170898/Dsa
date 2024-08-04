package org.dsa.Arrays;

public class A23RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

    }
//    https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1173166419/
    public Integer removeDuplicates(int[] arr, int N){
        int i=0;
        for (int j=1; j<N; j++){
            if(arr[j]!= arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }

}
