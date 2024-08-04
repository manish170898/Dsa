package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class R13Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        subsets(nums);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recSubsets(0, nums, list, subsets);
        return subsets;
    }

    public static void recSubsets(int index, int[] nums, List<Integer> list,  List<List<Integer>> subsets){
        if(index == nums.length){
            subsets.add(list);
            return;
        }
        list.add(nums[index]);
        recSubsets(index+1, nums, list, subsets);
        list.remove(new Integer(nums[index]));
        recSubsets(index+1, nums, list, subsets);
    }
}
