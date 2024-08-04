package org.dsa.Trees;

public class T29CeilInBST {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        Node newRoot = new Node(1);
        newRoot.left = new Node(2);
        newRoot.right = new Node(3);
        newRoot.left.left = new Node(4);
        newRoot.left.right = new Node(5);
        newRoot.right.left = new Node(6);
    }

    public static int ceil(Node node, int target){
        int ceil = -1;
        while(node != null){
            if(node.data == target){
                ceil = node.data;
                return ceil;
            }

            if(target > node.data){
                node = node.right;
            }
            else{
                ceil = node.data;
                node = node.left;
            }
        }
        return ceil;
    }

}
