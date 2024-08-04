package org.dsa.Trie;

class TrieNode {
    TrieNode[] dict = new TrieNode[26];
    boolean flag = false;
    boolean containsKey(char ch){
        return dict[ch-'a'] != null;
    }
    void put(char ch, TrieNode node){
        dict[ch-'a'] = node;
    }
    TrieNode get(char ch){
        return dict[ch-'a'];
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }

}
public class T1Trie {
    private TrieNode root;
    T1Trie(){
        root = new TrieNode();
    }
//    TC - O(length of word)
    void insert(String word){
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    //    TC - O(length of word)
    boolean search(String word){
        TrieNode node = root;
        for (int i=0; i< word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            else{
                node = node.get(word.charAt(i));
            }
        }
        return node.isEnd();
    }
    //    TC - O(length of word)
    boolean startsWith(String prefix){
        TrieNode node = root;
        for(int i=0; i< prefix.length(); i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            else{
                node = node.get(prefix.charAt(i));
            }
        }
        return true;
    }
}
