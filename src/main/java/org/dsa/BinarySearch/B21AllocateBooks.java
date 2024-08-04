package org.dsa.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B21AllocateBooks {
//    https://www.naukri.com/code360/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        List<Integer> list = List.of(12, 34, 67, 90);
        findPages(new ArrayList<>(list), n, m);
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m>n) return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(Integer ar : arr){
            high += ar;
            if(ar > low) low = ar;
        }

        int ans = -1;

        while(low <= high){
            int mid = (low+high)/2;
            int noOnStudents = findNoOfStudents(arr, mid, m);
            if(noOnStudents > m) low = mid+1;
            else high = mid -1;
        }
        return low;
    }

    public static int findNoOfStudents(ArrayList<Integer> arr, int mid, int m){
        int students = 0;
        int sum = 0;
        int i = 0;
        while(i < arr.size()){
            if(students > m){
                return students;
            }
            if(sum + arr.get(i) > mid){
                students ++;
                sum = arr.get(i);
            }
            else{
                sum += arr.get(i);
            }
            i++;
        }
        if(sum > 0) students++;
        return students;
    }
}
