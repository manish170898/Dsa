package org.dsa.SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class Q12MinimumWindowSubstring {
//    https://leetcode.com/problems/minimum-window-substring/description/
    public static void main(String[] args) {
        String s ="ADOBECODEBANC";
        String t ="ABC";

        minWindow(s, t);
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map =new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) +1);
        }
        int k = map.size();
        int l = 0;
        int r = 0;
        int count = 0;
        int ansLen = Integer.MAX_VALUE;
        int startIndex = 0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)-1);
            if(map.get(s.charAt(r)) == 0){
                count++;
            }
            while(count>=k){
                if((r-l+1) < ansLen){
                    ansLen = r-l+1;
                    startIndex = l;
                }
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)+1);
                if(map.get(s.charAt(l)) > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        StringBuilder ans = new StringBuilder("");
        if(ansLen == Integer.MAX_VALUE) return ans.toString();

        for(int i=startIndex; i<startIndex + ansLen ; i++){
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

}
