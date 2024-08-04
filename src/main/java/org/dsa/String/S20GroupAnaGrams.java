package org.dsa.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S20GroupAnaGrams {
    public static void main(String[] args) {
        String[] a = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(a);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int[] dict = new int[26];
        for(String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                int pos = str.charAt(i) - 'a';
                dict[pos]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (dict[i] > 0) {
                    int k = dict[i];
                    while (k > 0) {
                        sb.append((char) (97 + i));
                        k--;
                    }
                    dict[i] = 0;
                }
            }
            if (map.get(sb.toString()) != null) {
                List<String> list = new ArrayList<>(map.get(sb.toString()));
                list.add(str);
                map.put(sb.toString(), list);
            } else {
                map.put(sb.toString(), List.of(str));
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
