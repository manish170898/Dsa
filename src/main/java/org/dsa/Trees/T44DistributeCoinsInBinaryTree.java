package org.dsa.Trees;


public class T44DistributeCoinsInBinaryTree {
//    https://leetcode.com/problems/distribute-coins-in-binary-tree/description/?envType=daily-question&envId=2024-05-18
public int distributeCoins(Node root) {
    int[] count = new int[1];
    dfs(root, count);
    return count[0];
}

    private int dfs(Node node, int[] count) {
        if(node == null) return 0;
        int left = dfs(node.left, count);
        int right = dfs(node.right, count);

        int movesRequired = left + right + (node.data -1);
        count[0] += Math.abs(movesRequired);

        return movesRequired;
    }
}
