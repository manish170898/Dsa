package org.dsa.Sorting;

import java.util.Arrays;

public class MergeSort {
    //TC-O(nlogN)
    //SC-O(N)
    public static void main(String[] args) {
        int[] arr = new int[]{4 ,3 ,1 ,2};
        int n=4;
        mergeSort(arr, 0 ,n-1);
        System.out.println(Arrays.toString(arr));
    }
    //DIVIDE AND MERGE
    // So basically we divide the array till we are not able to divide it further that is till we reach one element
    //Then we start merging them and this time we sort while wwe merge .. so Merge sort
    public static void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        mergeBoth(arr, low, mid, high);
    }

    private static void mergeBoth(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high+1];
        int left = low;
        int right= mid +1;
        int i=0;
        while (left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                left++;
                i++;
            }
            else{
                temp[i] = arr[right];
                right++;
                i++;
            }
        }
        while (left<=mid){
            temp[i] = arr[left];
            left++;
            i++;
        }
        while (right<=high){
            temp[i] = arr[right];
            right++;
            i++;
        }
        for (int j= low; j<=high; j++){
            arr[j] = temp[j-low];
        }
    }

}
