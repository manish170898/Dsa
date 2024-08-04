package org.dsa.Graph;

import java.util.*;

public class G25WordLadder2 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        findLadders(beginWord,endWord,wordList);
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(List.of(beginWord)));
        ArrayList<String> usedOnLevel = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return new ArrayList<>();
        while (!queue.isEmpty() && ans.isEmpty()){
            int qSize = queue.size();
            usedOnLevel.forEach(dict::remove);
            for(int i=0; i<qSize; i++){
                ArrayList<String> midSeq= queue.poll();
                if (midSeq.get(midSeq.size()-1).equalsIgnoreCase(endWord)){
                    ans.add(midSeq);
                }
                char[] word = midSeq.get(midSeq.size()-1).toCharArray();
                for (int j=0; j<word.length; j++){
                    char tempLetter = word[i];
                    for (char letter = 'a'; letter <= 'z'; letter++){
                        word[j] = letter;
                        String possibleWord =  String.valueOf(word);
                        if (dict.contains(possibleWord)){
                            ArrayList<String> list= new ArrayList<>(midSeq);
                            list.add(possibleWord);
                            queue.add(list);
                            usedOnLevel.add(possibleWord);
                        }
                    }
                    word[j] = tempLetter;
                }
            }

        }
        return ans;
    }
}
