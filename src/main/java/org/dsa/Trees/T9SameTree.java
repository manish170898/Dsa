package org.dsa.Trees;
//https://leetcode.com/problems/same-tree/
public class T9SameTree {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(isSameTree(root, root));
    }

    public static boolean isSameTree(Node p, Node q) {
        if(p == null || q == null)
            return p==q;
        return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
