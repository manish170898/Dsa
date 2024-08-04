package org.dsa.Arrays;

import java.util.HashMap;
import java.util.Map;

public class A38ContiniousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0,-1);
        for(int i=1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]%k) == null){
                map.put(nums[i]%k, i);
            }
            else{
                int len = i - map.get(nums[i]%k);
                if(len >=2) return true;
            }
        }
        return false;
    }
}
