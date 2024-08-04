package org.dsa.Trie;
//https://www.naukri.com/code360/problems/complete-string_2687860
class TrieNode3{
    TrieNode3[] dict = new TrieNode3[26];
    int end = 0;
    boolean containsKey(char ch){
        return dict[ch-'a'] != null;
    }
    void put(char ch){
        dict[ch-'a'] = new TrieNode3();
    }
    TrieNode3 get(char ch){
        return dict[ch-'a'];
    }
    void incEnd(){
        end ++;
    }
    int getEnd(){
        return end;
    }
}

public class T3CompleteString {
    public static String completeString(int n, String[] a) {
        // Write your code here.
        TrieNode3 root = new TrieNode3();
        for (String word : a) {
            insert(word.toLowerCase(), root);
        }
        int maxIndex = Integer.MAX_VALUE;
        int longest = 0;
        for (int i = 0; i < n; i++) {
            if (check(a[i].toLowerCase(), root)) {
                if (maxIndex == Integer.MAX_VALUE) maxIndex = i;
                else if (a[i].length() > a[maxIndex].length()) {
                    maxIndex = i;
                } else if (a[i].length() == a[maxIndex].length() && a[i].compareTo(a[maxIndex]) < 0) {
                    maxIndex = i;
                }
            }
        }
        return maxIndex == Integer.MAX_VALUE ? "None" : a[maxIndex];
    }

    public static void insert(String word, TrieNode3 node) {
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.incEnd();
    }

    public static boolean check(String word, TrieNode3 node) {
        for (int i = 0; i < word.length(); i++) {
            node = node.get(word.charAt(i));
            if (node.getEnd() < 1) return false;
        }
        return true;
    }
}