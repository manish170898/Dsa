package org.dsa.Trie;

//https://www.naukri.com/code360/problems/count-distinct-substrings_985292?count=25&page=1&search=&sort_entity=order&sort_order=ASC
class TrieNode4{
    TrieNode4[] dict = new TrieNode4[26];
    boolean containsKey(char ch){
        return dict[ch-'a'] != null;
    }
    void put(char ch){
        dict[ch-'a'] = new TrieNode4();
    }
    TrieNode4 get(char ch){
        return dict[ch-'a'];
    }
}
public class T4CountDistinctSubstrings {
    static int ans =0;
    public static int countDistinctSubstrings(String s)
    {
        //	  Write your code here.
        ans = 0;
        TrieNode4 node = new TrieNode4();
        for(int i=0; i<s.length(); i++){
            insert(s.substring(i), node);
        }
        return ++ans;
    }

    public static void insert(String word, TrieNode4 node) {
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i));
                ans++;
            }
            node = node.get(word.charAt(i));
        }
    }

    public static void main(String[] args) {
        countDistinctSubstrings("sds");
    }
}
