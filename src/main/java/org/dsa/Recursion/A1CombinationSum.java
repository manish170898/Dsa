package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/

public class A1CombinationSum {

    public static void main(String[] args){
        int[] candidates = new int[]{2,3,6,7};
        int target =7;
        System.out.println(combinationSum(candidates, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recursionCombinationSum(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    public static void recursionCombinationSum(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> ds){
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index] <= target){
            ds.add(candidates[index]);
            recursionCombinationSum(index, candidates, target-candidates[index], result, ds);
            ds.remove(ds.size()-1);
        }
        recursionCombinationSum(index + 1, candidates, target, result,ds);
    }

}
