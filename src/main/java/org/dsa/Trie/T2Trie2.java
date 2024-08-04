package org.dsa.Trie;

class TrieNode2{
    TrieNode2[] dict = new TrieNode2[26];
    int endWith = 0;
    int countPrefix = 0;

    boolean containsKey(char ch){
        return dict[ch-'a'] != null;
    }
    void put(char ch, TrieNode2 node){
        dict[ch-'a'] = node;
    }
    TrieNode2 get(char ch){
        return dict[ch - 'a'];
    }
    void incCountPrefix(){
        countPrefix++;
    }
    void decCountPrefix(){
        countPrefix--;
    }
    void incEndsWith(){
        endWith++;
    }
    void decEndsWith(){
        endWith--;
    }
    int getcountPrefix(){
        return countPrefix;
    }
    int getEndWith(){
        return endWith;
    }
}

public class T2Trie2 {
    TrieNode2 root;
    public T2Trie2() {
        // Write your code here.
        root = new TrieNode2();
    }

    public void insert(String word) {
        // Write your code here.
        TrieNode2 node = root;
        for(int i=0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new TrieNode2());
            }
            node = node.get(word.charAt(i));
            node.incCountPrefix();
        }
        node.incEndsWith();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        TrieNode2 node = root;
        for(int i=0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEndWith();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        TrieNode2 node = root;
        for(int i=0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getcountPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        TrieNode2 node = root;
        for(int i=0; i<word.length(); i++){
            node = node.get(word.charAt(i));
            node.decCountPrefix();
        }
        node.decEndsWith();
    }

}

