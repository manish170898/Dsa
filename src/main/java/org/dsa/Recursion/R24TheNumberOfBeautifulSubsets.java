package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class R24TheNumberOfBeautifulSubsets {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6};
        int k = 2;
        beautifulSubsets(nums, k);
    }

    public static int beautifulSubsets(int[] nums, int k) {
        List<Integer> ds = new ArrayList<>();
        int[] count = new int[1];
        rec(nums.length-1, nums, k, ds, count, false);
        return count[0];
    }

    public static void rec(int index, int[] nums, int k, List<Integer> ds, int[] count, boolean added){
        if(added){
            if(ds.size() == 1) count[0]++;
            if(ds.size() > 1){
                int searchForPlusK = ds.get(ds.size()-1) + k;
                int searchForMinusK = ds.get(ds.size()-1) - k;
                for(int i=0; i<ds.size(); i++){
                    if(ds.get(i) == searchForPlusK || ds.get(i) == searchForMinusK){
                        return;
                    }
                }
                count[0]++;
            }
        }
        if(index < 0){
            return;
        }
        ds.add(nums[index]);
        rec(index - 1, nums, k, ds, count, true);
        ds.remove(ds.size()-1);
        rec(index - 1, nums, k, ds, count, false);
        return;
    }
}
