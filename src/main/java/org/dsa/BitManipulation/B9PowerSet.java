package org.dsa.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class B9PowerSet {
    public static void main(String[] args) {
        // NUmber fo subsets will be 1<<N which is 2powN
        int[]  nums = new int[]{1,2,3};
        int noOfSubsets = 1 << nums.length;
        List<List<Integer>> ans = new ArrayList<>();
//        TC - N * 2powN
        for(int i=0; i< noOfSubsets; i++){
            List<Integer> lst =new ArrayList<>();
            for(int j=0; j<nums.length; j++){
                if((i & (1<<j)) != 0){
                    lst.add(nums[j]);
                }
            }
            ans.add(lst);
        }

        System.out.println(ans);
    }
}
