package org.dsa.BinarySearch;

public class B8SearchInRotatedSortedArrayII {
//    https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[high] && nums[mid] == nums[low]){
                low++;
                high--;
                continue;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid - 1;
                }
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
        return false;
    }
}
