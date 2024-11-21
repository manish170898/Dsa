package org.dsa.Trees;

public class T35checkIfBtisBST {
//    https://leetcode.com/problems/validate-binary-search-tree/description/
    public static void main(String[] args20) {
        Node newRoot = new Node(1);
        newRoot.left = new Node(2);
        newRoot.right = new Node(9);
    }
     public boolean checkBST(Node root, int min, int max){
         if(root == null) return true;
         if(root.data >= max || root.data <= min) return false;
         return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
     }
}
