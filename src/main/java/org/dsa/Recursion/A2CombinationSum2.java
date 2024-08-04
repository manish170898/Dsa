package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/combination-sum-ii/
public class A2CombinationSum2 {
    public static void main(String[] args){
        int[] candidates = new int[]{3,2,2,6,7};
        int target =7;
        System.out.println(combinationSum(candidates, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        recursionCombinationSum(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    public static void recursionCombinationSum(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> ds){
        if(target == 0){
            result.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i] == candidates[i-1]){continue;}
            if(candidates[i] > target){break;}

            ds.add(candidates[i]);
            recursionCombinationSum(i+1, candidates, target-candidates[i], result, ds);
            ds.remove(ds.size()-1);
        }
    }
}
