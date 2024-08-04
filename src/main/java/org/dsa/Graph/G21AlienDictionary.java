package org.dsa.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class G21AlienDictionary {
    public static void main(String[] args) {
        String[] str = new String[]{"caa", "aaa", "aab"};
        System.out.println(getAlienLanguage(str,3));
    }
    public static String getAlienLanguage(String []dictionary, int k) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i =0; i<k; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i< dictionary.length-1; i++){
            char[] word1 = dictionary[i].toCharArray();
            char[] word2 = dictionary[i+1].toCharArray();
            for(int j=0; j<Math.min(word1.length, word2.length); j++){
                if(word1[j] != word2[j]){
                    list.get(word1[j]-'a').add(word2[j]-'a');
                    break;
                }
            }
        }
        int[] topo = G16TopologicalSortBfsKhans.topoSort(k,list);
        StringBuilder sb = new StringBuilder();
        for (Integer ele: topo){
            sb.append((char) ('a' + ele));
        }
        return sb.toString();
        // Write your code here.
    }
}
