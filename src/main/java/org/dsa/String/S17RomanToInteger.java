package org.dsa.String;

import java.util.HashMap;
import java.util.Map;

public class S17RomanToInteger {
    public int romanToInt(String s) {
//        https://leetcode.com/problems/roman-to-integer/
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int answer = 0;

        for(int i=0; i<s.length(); i++){
            if(i+1<s.length()){
                if(s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                    answer = answer - map.get(s.charAt(i));
                }
                else if(s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                    answer = answer - map.get(s.charAt(i));
                }
                else if(s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                    answer = answer - map.get(s.charAt(i));
                }
                else answer = answer + map.get(s.charAt(i));
            }
            else{
                answer = answer + map.get(s.charAt(i));
            }
        }
        return answer;
    }
}
