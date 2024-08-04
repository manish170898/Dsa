package org.dsa.Arrays;

import java.util.HashMap;
import java.util.Map;

public class A39SubarraySumsDivisibleByK {
//    https://leetcode.com/problems/subarray-sums-divisible-by-k/description/?envType=daily-question&envId=2024-06-10
    public int subarraysDivByK(int[] nums, int k) {
    Map<Integer, Integer> map =new HashMap<>();
    int count = 0;
    map.put(0,1);
    for(int i=1; i<nums.length; i++){
        nums[i] += nums[i-1];
    }
    for(int i=0; i<nums.length; i++){
        int remainder = nums[i]%k;
        // converting -ve remainder into positive
        if(remainder <0){
            remainder += k;
        }
        if(map.get(remainder) == null){
            map.put(remainder, 1);
        }
        else{
            count += map.get(remainder);
            map.put(remainder, map.get(remainder) + 1);
        }
    }
    return count;
}

}
