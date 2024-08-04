package org.dsa.SlidingWindowTwoPointers;

import java.util.HashSet;
import java.util.Set;

public class Q1LongestSubstringWithoutRepeatingCharacters {
//    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int currMax = 0;
        int i=0, j=0;
        Set<Character> set = new HashSet<>();
        while(i< s.length()){
            char c = (s.charAt(i));
            if(!set.contains(c)){
                set.add(c);
                i++;
                currMax++;
            }
            else{
                max = Math.max(currMax, max);
                while(s.charAt(j) != c){
                    set.remove(s.charAt(j));
                    j++;
                    currMax--;
                }
                j++;
                i++;
            }
        }
        return Math.max(currMax, max);
    }
}
