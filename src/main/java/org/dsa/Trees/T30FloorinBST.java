package org.dsa.Trees;

public class T30FloorinBST {
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

    public static int floor(Node node, int target){
        int floor = -1;
        while(node != null){
            if(node.data == target){
                floor = node.data;
                return floor;
            }

            if(target < node.data){
                node = node.left;
            }
            else{
                floor = node.data;
                node = node.right;
            }
        }
        return floor;
    }
}
