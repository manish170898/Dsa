package org.dsa.Trees;


public class T4MaxDepthOfTree {
//    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(Node root){
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1+ Math.max(lh,rh);
    }

}