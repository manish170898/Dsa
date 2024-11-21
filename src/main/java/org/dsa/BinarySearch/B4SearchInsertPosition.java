package org.dsa.BinarySearch;

public class B4SearchInsertPosition {
//    https://leetcode.com/problems/search-insert-position/description/

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        int ans = 0;

        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                high = mid-1;
            }
            else {
                low = mid +1;
            }
        }
        // at the end either mid or mid+1 will be answer based on if number is greater than of less than mid
        if(target < nums[mid]) return mid;
        else return mid+1;
    }
}
