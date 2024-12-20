package org.dsa.Arrays;

public class A3SingleElementInASortedArray {

//    You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//    Return the single element that appears only once.
//    Your solution must run in O(log n) time and O(1) space.

//    Example 1:
//    Input: nums = [1,1,2,3,3,4,4,8,8]
//    Output: 2

//    Example 2:
//    Input: nums = [3,3,7,7,10,11,11]
//    Output: 10

//    Constraints:
//            1 <= nums.length <= 105
//            0 <= nums[i] <= 105

    public int singleNonDuplicate(int[] nums) {
        int high = nums.length -1;
        int low = 0;
        int mid;

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
            if((mid%2==0 && nums[mid] == nums[mid+1]) || (mid%2==1 && nums[mid] == nums[mid-1])){
                low = mid +1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
