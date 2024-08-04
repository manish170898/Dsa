package org.dsa.Trees;

public class T34KthLargestInBST {
    public static void main(String[] args20) {
        Node newRoot = new Node(1);
        newRoot.left = new Node(2);
        newRoot.right = new Node(9);

        kthLargest(newRoot, 2);
    }

    public static int kthLargest(Node root,int K)
    {
        Node cur = root;
        int count=0;
        int n = count(root);
        while(cur != null ){
            if(cur.left == null){
                count ++;
                if(count == (n-K+1)){
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
                    if(count == (n-K+1)){
                        return cur.data;
                    }
                    cur = cur.right;
                }
            }
        }
        return -1;
    }

    public static int count(Node root) {
        Node cur = root;
        int count=0;
        while(cur != null ){
            if(cur.left == null){
                count ++;
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
                    cur = cur.right;
                }
            }
        }
        return count;
    }
}
