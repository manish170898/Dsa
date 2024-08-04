package org.dsa.Trees;
//https://leetcode.com/problems/diameter-of-binary-tree/description/
public class T6DiamterOfaTree {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        int[] diameter= new int[1];
        diameter(root, diameter);
        System.out.println(diameter[0]);
    }

    public static int diameter(Node root, int[] diameter){
        if(root == null) return 0;
        int lh = diameter(root.left, diameter);
        int rh = diameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh+rh);

        return 1+ Math.max(lh,rh);
    }
}
