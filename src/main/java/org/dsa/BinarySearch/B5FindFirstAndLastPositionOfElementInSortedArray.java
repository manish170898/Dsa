package org.dsa.BinarySearch;

public class B5FindFirstAndLastPositionOfElementInSortedArray {
//    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        int[] ans = {-1, -1};
    // do bs two to one time you go left another time go right .. even if we find it still do this
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target){
                ans[0] = mid;
                high = mid-1;
            }
            else if(nums[mid] > target) high = mid-1;
            else low = mid +1;
        }

        low = 0;
        high = nums.length-1;
        mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target){
                ans[1] = mid;
                low = mid+1;
            }
            else if(nums[mid] > target) high = mid-1;
            else low = mid +1;
        }
        return ans;
    }
}
