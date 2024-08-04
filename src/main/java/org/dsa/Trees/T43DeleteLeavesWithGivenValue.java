package org.dsa.Trees;


public class T43DeleteLeavesWithGivenValue {
    public static void main(String[] args) {
//        https://leetcode.com/problems/delete-leaves-with-a-given-value/description/
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        removeLeafNodes(root, 3);
    }

    public static Node removeLeafNodes(Node root, int target) {
        boolean val = remove(root, target);
        if(val) root = null;
        return root;
    }

    public static boolean remove(Node root , int target){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return root.data == target;
        }
        boolean left = remove(root.left, target);
        boolean right = remove(root.right, target);
        if(left) root.left = null;
        if(right) root.right = null;

        return root.data == target && left && right;
    }
}
