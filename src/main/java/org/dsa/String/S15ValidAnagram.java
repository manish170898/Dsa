package org.dsa.String;

public class S15ValidAnagram {
    public boolean isAnagram(String s, String t) {
//        https://leetcode.com/problems/valid-anagram/
        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(int i=0; i<s.length(); i++){
            int pos = s.charAt(i) - 97;
            freqS[pos]++;
        }

        for(int i=0; i<t.length(); i++){
            int pos = t.charAt(i) - 97;
            freqT[pos]++;
        }

        for(int i=0; i<26; i++){
            if(freqS[i] != freqT[i]) return false;
        }
        return true;
    }
}
