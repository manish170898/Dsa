package org.dsa.Sorting;

public class QuickSort {
    public static void main(String[] args) {

    }
    //Intuition is Pick a pivot and place it in its place .. smaller on left larger on right
//    TC - O(nlogn)
    public static void quickSort(int[] arr, int low, int high ){
        if(low < high){
            int pivotInd = findPivot(arr, low, high);
            quickSort(arr, low, pivotInd-1);
            quickSort(arr, pivotInd+1, high);
        }

    }

    private static int findPivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        int lo = low;
        int hi = high;
        while (lo < hi){
            while (arr[lo] <= pivot  && lo <= high-1){
                lo++;
            }
            while (arr[hi] > pivot  && hi >= low+1){
                hi--;
            }
            if(lo < hi) {
                swap(arr, hi, lo);
            }
        }
        swap(arr, low, hi);
        return hi;
    }

    private static void swap(int[] arr, int swap1, int swap2){
        int temp = arr[swap1];
        arr[swap1] = arr[swap2];
        arr[swap2] = temp;
    }


}
