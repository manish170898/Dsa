package org.dsa.Arrays;

import java.util.HashMap;
import java.util.Map;

public class A35LongestPallindrone {
//    https://leetcode.com/problems/longest-palindrome/description/?envType=daily-question&envId=2024-06-04
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean isFirstOdd = true;
        int lastOddLen = 0;
        int ans = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() %2 == 0){
                ans += entry.getValue();
            }
            else if(entry.getValue() %2 == 1){
                if(isFirstOdd){
                    ans+=entry.getValue();
                    isFirstOdd = false;
                }
                else{
                    ans+=entry.getValue();
                    ans-=1;
                }
            }
        }
        return ans;
    }
}

