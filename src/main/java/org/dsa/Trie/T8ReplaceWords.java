package org.dsa.Trie;

import java.util.List;

public class T8ReplaceWords {
//    https://leetcode.com/problems/replace-words/?envType=daily-question&envId=2024-06-07
public String replaceWords(List<String> dictionary, String sentence) {
    TrieNode7 node = new TrieNode7();
    for(String word : dictionary){
        insert(word,node);
    }
    String[] words = sentence.split(" ");
    StringBuilder sb = new StringBuilder();

    for(int i=0 ; i < words.length; i++){
        int ind = search(words[i], node);
        if(ind == -1) sb.append(words[i]);
        else sb.append(words[i].substring(0,ind+1));
        if(i!= words.length-1) sb.append(" ");
    }
    return sb.toString();
}

    int search(String word, TrieNode7 node){
        for(int i=0; i< word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return -1;
            }
            node = node.get(word.charAt(i));
            if(node.getFlag() == true) {
                return i;
            }
        }
        return -1;
    }

    void insert(String word, TrieNode7 node){
        for(int i=0; i< word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.setFlag();
    }
}
class TrieNode7{
    TrieNode7[] dict = new TrieNode7[26];
    boolean flag = false;
    boolean containsKey(char ch){
        return dict[ch-'a']!= null;
    }
    void put(char ch){
        dict[ch-'a'] = new TrieNode7();
    }
    TrieNode7 get(char ch){
        return dict[ch-'a'];
    }
    void setFlag(){
        this.flag = true;
    }
    boolean getFlag(){
        return flag;
    }
}

