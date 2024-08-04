package org.dsa.Trees;

public class T5CheckBalancedBT {
//    https://leetcode.com/problems/balanced-binary-tree/description/
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(checkBalanced(root) != -1);
    }

    public static int checkBalanced(Node root){
        if(root == null) return 0;
        int lh = checkBalanced(root.left);
        if(lh == -1) return -1;
        int rh = checkBalanced(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh-rh) > 1) return -1;
        return 1+ Math.max(lh,rh);
    }

}
