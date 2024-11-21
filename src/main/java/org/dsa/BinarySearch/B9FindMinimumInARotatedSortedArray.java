package org.dsa.BinarySearch;

public class B9FindMinimumInARotatedSortedArray {
//    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            mid = (low + high)/2;
            // in normal side compare with lowest elemnt and go opposite side .. as you now have lowest elemnt since it is sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] < ans) ans = nums[low];
                low = mid+1;
            }
            else{
                if(nums[mid] < ans) ans = nums[mid];
                high = mid-1;
            }
        }
        return ans;
    }
}
