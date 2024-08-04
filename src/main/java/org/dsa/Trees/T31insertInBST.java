package org.dsa.Trees;

public class T31insertInBST {
    public static void main(String[] args20) {
        Node newRoot = new Node(1);
        newRoot.left = new Node(2);
        newRoot.right = new Node(3);
        newRoot.left.left = new Node(4);
        newRoot.left.right = new Node(5);
        newRoot.right.left = new Node(6);
    }

    public static Node insertInBST(Node node, int target){
        if(node == null) return new Node(target);
        Node cur = node;
        while(true) {
            if (target > cur.data) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new Node(target);
                    break;
                }
            }
            else if (target < cur.data) {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new Node(target);
                    break;
                }
            }
        }
        return node;
    }

}
