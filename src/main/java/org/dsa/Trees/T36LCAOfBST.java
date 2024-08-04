package org.dsa.Trees;

public class T36LCAOfBST {
    public static void main(String[] args20) {
        Node newRoot = new Node(1);
        newRoot.left = new Node(2);
        newRoot.right = new Node(9);
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;
        if(root.data > p.data && root.data > q.data){
            lowestCommonAncestor(root.left, p, q);
        }
        if(root.data < p.data && root.data < q.data){
            lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
