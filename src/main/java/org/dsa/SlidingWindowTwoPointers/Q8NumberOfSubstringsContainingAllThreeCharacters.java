package org.dsa.SlidingWindowTwoPointers;

public class Q8NumberOfSubstringsContainingAllThreeCharacters {
//    https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
    public int numberOfSubstrings(String s) {
        int atMostTwo = atMostK(s, 2);
        int atMostThree = atMostK(s, 3);
        return atMostThree - atMostTwo;
    }

    public int atMostK(String s, int k){
        int n = s.length();
        int[] arr = new int[26];
        int count = 0;
        int l=0, r=0;
        int ans = 0;
        while(r<n){
            if(arr[s.charAt(r)-'a'] == 0){
                arr[s.charAt(r)-'a']++;
                count++;
            }
            else{
                arr[s.charAt(r)-'a']++;
            }

            while(count > k){
                if(arr[s.charAt(l)-'a'] == 1){
                    arr[s.charAt(l)-'a']--;
                    count--;
                }
                else{
                    arr[s.charAt(l)-'a']--;
                }
                l++;
            }
            ans += r-l+1;
            r++;
        }
        return ans;
    }
}
