package org.dsa.BinarySearch;

public class B12FindPeakElement {
//    https://leetcode.com/problems/find-peak-element/
    public int findPeakElement(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        if(high == 0){
            return 0;
        }
        if(nums[high] > nums[high-1]){
            return high;
        }
        if(nums[low] > nums[low+1]){
            return low;
        }
        low = 1;
        high = high-1;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(nums[mid] < nums[mid-1]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return 0;
    }
}
