package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/permutations/
public class A5Permutations {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,2,6,7};
        int target =7;
        System.out.println(permutation(nums, target));
    }
    public static List<List<Integer>> permutation(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recursivePermutation(freq, nums, result, new ArrayList<>());
        return result;
    }
//APPROACH 1  with O(N) extra space

    public static void recursivePermutation(boolean[] freq, int[] nums, List<List<Integer>> result, List<Integer> ds){
        if(ds.size()-1 == nums.length){
            result.add(new ArrayList<>(ds));
        }
        for(int i = 0 ; i< nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                recursivePermutation(freq, nums, result, ds);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }

    public static void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // WAY 2 - more optimized
    public static void recursivePermutation1(int index, int[] nums, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            result.add(ds);
            return;
        }

        for (int i=index; i<nums.length; i++){
            swap(i, index, nums);
            recursivePermutation1(index + 1, nums, result);
            swap(i, index, nums);
        }
    }

}
