package org.dsa.String;

import java.util.HashMap;

public class S1IsomorphicStrings {
//    https://leetcode.com/problems/isomorphic-strings/?envType=daily-question&envId=2024-04-02
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (map.containsKey(charS)) {
                if (map.get(charS) != charT) {
                    return false;
                }
            } else {
                if (reverseMap.containsKey(charT)) {
                    return false;
                }
                map.put(charS, charT);
                reverseMap.put(charT, charS);
            }
        }

        return true;
    }
}
