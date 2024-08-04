package org.dsa.SlidingWindowTwoPointers;

public class Q9LongestRepeatingCharacterReplacement {
//    https://leetcode.com/problems/longest-repeating-character-replacement/
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l=0;
        int r=0;
        int[] dict = new int[26];
        int ans = 0;
        int maxFreq = 0;
        while(r<n){
            dict[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, dict[s.charAt(r)-'A']);
            if((r-l+1) - maxFreq > k){
                dict[s.charAt(l)-'A']--;
                // Actually we dont need to decrease the freq ... as we only need greater than what we have now
                maxFreq = 0;
                for(int i=0; i<26; i++){
                    maxFreq = Math.max(maxFreq, dict[i]);
                }
                l++;
            }
            if((r-l+1) - maxFreq <= k){
                ans= Math.max(ans, r-l+1);
            }
            r++;
        }
        return ans;
    }

}
