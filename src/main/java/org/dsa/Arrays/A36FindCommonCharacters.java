package org.dsa.Arrays;

import java.util.ArrayList;
import java.util.List;

public class A36FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] first = count(words[0]);

        for(int i=1; i<words.length; i++){
            first = intersection(first, count(words[i]));
        }

        List<String> ans = new ArrayList<>();
        for(int i=0; i<26; i++){
            if(first[i] != 0){
                char c = (char)(i + 'a');
                while(first[i]!= 0){
                    ans.add(String.valueOf(c));
                    first[i]--;
                }
            }

        }
        return ans;
    }

    int[] intersection(int[] a, int[] b){
        int[] arr = new int[26];
        for(int i=0; i<26; i++){
            arr[i] = Math.min(a[i], b[i]);
        }
        return arr;
    }

    int[] count(String word){
        int[] arr = new int[26];
        for(int i=0; i<word.length(); i++){
            arr[word.charAt(i)-'a']++;
        }
        return arr;
    }
}
