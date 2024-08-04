package org.dsa.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TrieNodeW {
    TrieNodeW [] child = new TrieNodeW [26];
    LinkedList<String> suggestion = new LinkedList<>();
}
public class T7SearchSuggestionSystem {
    private TrieNodeW root = new TrieNodeW();
    public void insert(String word) {
        TrieNodeW node = root;
        for (char ch : word.toCharArray()){
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNodeW();
            }
            node = node.child[index];
            node.suggestion.offer(word);
            if (node.suggestion.size() > 3) {
                node.suggestion.pollLast();
            }
        }
    }

    public List<List<String>> search(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNodeW node = root;
        for (char ch : searchWord.toCharArray()) {
            int index = ch - 'a';
            if (node != null) {
                node = node.child[index];
            }
            result.add(node == null ? Arrays.asList() : node.suggestion);
        }
        return result;
    }
}
