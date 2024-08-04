package org.dsa.Trees;

public class T33KthSmallestInBST {
    public static void main(String[] args20) {
        Node newRoot = new Node(1);
        newRoot.left = new Node(2);
        newRoot.right = new Node(3);
        newRoot.left.left = new Node(4);
        newRoot.left.right = new Node(5);
        newRoot.right.left = new Node(6);

    }

    public static int kthSmallest(Node root, int k) {
        Node cur = root;
        int count=0;
        while(cur != null ){
            if(cur.left == null){
                count ++;
                if(count ==k){
                    return cur.data;
                }
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    cur= cur.left;
                }
                else{
                    prev.right = null;
                    count ++;
                    if(count ==k){
                        return cur.data;
                    }
                    cur = cur.right;
                }
            }
        }
        return -1;
    }
}
