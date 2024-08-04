package org.dsa.BinarySearch;

public class B11SingleElementInASortedArray {

//    https://leetcode.com/problems/single-element-in-a-sorted-array/
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        if(high == 0){
            return nums[0];
        }
        if(nums[high] != nums[high-1]){
            return nums[high];
        }
        if(nums[low] != nums[low+1]){
            return nums[low];
        }
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid] == nums[mid-1]){
                if(mid%2 == 1) low = mid+1;
                else high = mid-1;
            }
            else if(nums[mid] == nums[mid+1]){
                if(mid%2 == 0) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}
