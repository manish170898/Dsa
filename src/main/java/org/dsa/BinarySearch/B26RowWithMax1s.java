package org.dsa.BinarySearch;

public class B26RowWithMax1s {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int ans = 0 ;
        int currLow = Integer.MAX_VALUE;
        for(int i=0; i< n; i++){
            int low = 0;
            int high = m-1;
            while(low <= high){
                int mid = (low+high)/2;
                if(arr[i][mid] == 1){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            if(high < currLow){
                ans = i;
                currLow = high;
            }
        }
        if(currLow == m-1) return -1;
        return ans;
    }
}
