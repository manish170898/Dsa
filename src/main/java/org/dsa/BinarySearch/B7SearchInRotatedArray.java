package org.dsa.BinarySearch;

public class B7SearchInRotatedArray {
//    https://leetcode.com/problems/search-in-rotated-sorted-array/
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        // keep doing binary search in the side that is in order .. there will always be one side that is in order
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
//                if in between then search there
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid - 1;
                }
                // else go to other side
                else{
                    low = mid + 1;
                }
            }
            else{
                if(nums[mid] <= target && nums[high] >=target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
