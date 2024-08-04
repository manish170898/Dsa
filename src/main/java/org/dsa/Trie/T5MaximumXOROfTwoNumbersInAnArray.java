package org.dsa.Trie;

public class T5MaximumXOROfTwoNumbersInAnArray {
//    https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
    public int findMaximumXOR(int[] nums) {
        int maxA = 0;
        int maxXor = 0;
        TrieNode5 root = new TrieNode5();
        int ans = 0;

        for(int num : nums){
            insert(num, root);
        }
        for(int num : nums){
            maxA = num;
            ans = Math.max(ans, check(maxA, root));
        }
        return ans;
    }

    public void insert(int num, TrieNode5 node){
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit);
            }
            node = node.get(bit);
        }
    }

    public int check(int maxA, TrieNode5 node){
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

class TrieNode5{
    TrieNode5[] dict = new TrieNode5[2];
    boolean containsKey(int bit){
        return dict[bit] != null;
    }
    TrieNode5 get(int bit){
        return dict[bit];
    }
    void put(int bit){
        dict[bit] = new TrieNode5();
    }
}
