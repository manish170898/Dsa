package org.dsa.BinarySearch;

public class B6NumberOfOccurrence {
//    https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence
    int count(int[] arr, int n, int x) {
        int low = 0;
        int high = n-1;
        int mid = 0;
        int[] ans = {-1, -2};

        while(low <= high){
            mid = (low + high)/2;
            if(arr[mid] == x){
                ans[0] = mid;
                high = mid-1;
            }
            else if(arr[mid] > x) high = mid-1;
            else low = mid +1;
        }

        low = 0;
        high = n-1;
        mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(arr[mid] == x){
                ans[1] = mid;
                low = mid+1;
            }
            else if(arr[mid] > x) high = mid-1;
            else low = mid +1;
        }
        return ans[1]-ans[0]+1;
    }

}
