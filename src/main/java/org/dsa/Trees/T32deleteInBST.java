package org.dsa.Trees;

public class T32deleteInBST {
    public static void main(String[] args20) {
        Node newRoot = new Node(1);
        newRoot.left = new Node(2);
        newRoot.right = new Node(3);
        newRoot.left.left = new Node(4);
        newRoot.left.right = new Node(5);
        newRoot.right.left = new Node(6);

    }

    public static void deleteInBST(Node node, int target){
        if(node == null) return;

        if(node.data == target){

        }
        while(node != null){
            if(target < node.data){
                if(node.left != null && node.left.data ==target){
                    node.left = helper(node.left);
                    break;
                }
                else {
                    node =node.left;
                }
            }
            if(target > node.data){
                if(node.right != null && node.right.data ==target){
                    node.right = helper(node.right);
                    break;
                }
                else {
                    node =node.right;
                }
            }
        }
    }

    public static Node helper(Node node){
        if(node.left == null){
            return node.right;
        }
        else if(node.right == null){
            return node.left;
        }
        else {
            Node n = getLastRight(node.left);
            n.right = node.right;
            return node.left;
        }
    }

    public static Node getLastRight(Node node){
        if(node.right == null){
            return node;
        }
        return getLastRight(node.right);
    }



}
