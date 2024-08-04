package org.dsa.String;

import java.util.Map;
import java.util.TreeMap;

public class S12SumofBeautyAllSubstrings {
//    https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

    public int beautySum(String s) {
        int n = s.length();
        Map<Character, Integer> map = new TreeMap<>();
        int ans = 0;

        for(int i=0; i<n; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
            for(int j=i+1; j<n; j++){
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j), 0)+1);
                if(map.size() >1){
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        int val = entry.getValue();
                        if(val < min) min = val;
                        if(val > max) max = val;
                    }
                    ans+= max-min;
                }
            }
            map.clear();
        }
        return ans;
    }
}

