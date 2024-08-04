package org.dsa.BinarySearch;

public class B10FindHowManyTimesArrayHasBeenRotated {
//    https://www.geeksforgeeks.org/problems/rotation4723/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotation
    int findKRotation(int arr[], int n) {
        // code here
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        int ans = 0;

        while(low <= high){
            mid = (low + high)/2;
            if(arr[low] <= arr[mid]){
                if(arr[low] < arr[ans]) ans = low;
                low = mid+1;
            }
            else{
                if(arr[mid] < arr[ans]) ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}
