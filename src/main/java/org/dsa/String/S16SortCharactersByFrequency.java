package org.dsa.String;

import java.util.*;
import java.util.function.Function;

public class S16SortCharactersByFrequency {
//    https://leetcode.com/problems/sort-characters-by-frequency/description/
    public static void main(String[] args) {
        String s  = "tree";
        frequencySort(s);
    }
    public static String frequencySort(String s) {
//        could also be used
//        Map<String, Integer> newMap = new TreeMap<>(Collections.reverseOrder());
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            int cnt = entry.getValue();
            while(cnt != 0){
                sb.append(entry.getKey());
                cnt--;
            }
        }

        return sb.toString();
    }
}
