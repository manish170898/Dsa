package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/

//Given an integer array nums that may contain duplicates, return all possible
//        subsets
//        (the power set).
//
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,2]
//        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//        Example 2:
//
//        Input: nums = [0]
//        Output: [[],[0]]
//
//
//        Constraints:
//
//        1 <= nums.length <= 10
//        -10 <= nums[i] <= 10

public class A4SubsetSum2 {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,2,6,7};
        int target =7;
        System.out.println(subsetSum2(nums, target));
    }
    public static List<List<Integer>> subsetSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        recursuveSubsetSum2(0, nums, result, new ArrayList<>());
        return result;
    }

    public static void recursuveSubsetSum2(int index, int[] nums, List<List<Integer>> result, List<Integer> ds){
        result.add(new ArrayList<>(ds));
        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1]){continue;}
            ds.add(nums[i]);
            recursuveSubsetSum2(i+1, nums, result, ds);
            ds.remove(ds.size()-1);
        }
    }
}
