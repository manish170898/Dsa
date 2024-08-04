package org.dsa.Trie;

import java.util.Arrays;

public class T6MaximumXORWithAnElementFromArray {
//    https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
    TrieNode6 node;
    public int[] maximizeXor(int[] nums, int[][] queries) {
        node = new TrieNode6();
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        int[][] offlineQueries = new int[queries.length][3];
        for(int i=0; i<queries.length; i++){
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1];
            offlineQueries[i][2] = i;
        }
        Arrays.sort(offlineQueries, (a, b)-> a[1]-b[1]);
        int j = 0;
        for(int i=0; i<queries.length; i++){
            while(j<nums.length && nums[j]<=offlineQueries[i][1]){
                insert(nums[j], node);
                j++;
            }
            if(j!=0)ans[offlineQueries[i][2]] = check(offlineQueries[i][0], node);
            else ans[offlineQueries[i][2]] = -1;
        }
        return ans;
    }

    public void insert(int num, TrieNode6 node){
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit);
            }
            node = node.get(bit);
        }
    }

    public int check(int maxA, TrieNode6 node){
        int maxNum = 0;
        for(int i=31; i>=0; i--){
            int bit = (maxA >> i) & 1;
            if(node.containsKey(1-bit)){
                maxNum = maxNum | (1<< i);
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}
class TrieNode6{
    TrieNode6[] dict = new TrieNode6[2];
    boolean containsKey(int bit){
        return dict[bit] != null;
    }
    TrieNode6 get(int bit){
        return dict[bit];
    }
    void put(int bit){
        dict[bit] = new TrieNode6();
    }
}