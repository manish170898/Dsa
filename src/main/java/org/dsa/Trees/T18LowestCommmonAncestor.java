package org.dsa.Trees;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class T18LowestCommmonAncestor {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

//        System.out.println(lowestCommonAncestor(root));
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q) return root;

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        else
            return root;
    }
}
