package org.dsa.Recursion;

import java.util.HashMap;
import java.util.Map;

public class R25MaximumScoreWordsFormedByLetters {
    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        maxScoreWords(words, letters, score);
    }
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : letters){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        return rec(words.length-1, words, map, score);
    }

    static int rec(int index, String[] words, Map<Character, Integer> letters, int[] score){
        if(index < 0){
            return 0;
        }
        int pick = Integer.MIN_VALUE;
        String curWord = words[index];
        int sum = 0;
        int[] freq = new int[26];
        for(int i=0; i< curWord.length(); i++){
            freq[(int)(curWord.charAt(i) - 'a')]++;
            if(letters.get(curWord.charAt(i)) == null || letters.get(curWord.charAt(i)) < freq[(int)(curWord.charAt(i) - 'a')]){
                sum = -1;
                break;
            }
        }
        if(sum == 0){
            for(int i=0; i< curWord.length(); i++){
                sum+= score[(int)(curWord.charAt(i) - 'a')];
                letters.put(curWord.charAt(i), letters.get(curWord.charAt(i)) -1);
            }
            System.out.println("Word:" + curWord + " sum:" + sum);
            pick = sum + rec(index-1, words , letters, score);
            for(int i=0; i< curWord.length(); i++){
                letters.put(curWord.charAt(i), letters.get(curWord.charAt(i)) +1);
            }
        }
        int notPick = rec(index-1, words , letters, score);

        return Math.max(pick, notPick);
    }
}
