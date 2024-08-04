package org.dsa.Trees;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class T8MaxPathSum {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(Node root){
        if(root == null) return 0;
        int[] maxPath = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        backtrack(root, maxPath);
        return maxPath[0];
    }

    public static int backtrack(Node node, int[] maxPath){
        if(node == null) return 0;
        int maxL = backtrack(node.left, maxPath);
        if(maxL < 0) maxL =0;
        int maxR = backtrack(node.right, maxPath);
        if(maxR < 0) maxR =0;

        maxPath[0] = Math.max(maxPath[0], node.data + maxR + maxL);

        return node.data + Math.max(maxR, maxL);
    }

}
