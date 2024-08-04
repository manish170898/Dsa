package org.dsa.Trees;

import java.util.Stack;

public class T27FlattenBinaryTree {

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

    // Recursive Approach
    static Node prev = null;
    public static void rFlatten(Node node){
        if(node == null) return;

        rFlatten(node.right);
        rFlatten(node.left);

        node.right = prev;
        node.left = null;

        prev= node;
    }
    //Iterative Approach

    public static void iFlatten(Node node){
        Stack<Node> s= new Stack<>();
        s.push(node);
        while(!s.isEmpty()){
            Node curr = s.pop();
            if(curr.right != null){
                s.push(curr.right);
            }
            if(curr.left != null){
                s.push(curr.left);
            }
            if(!s.isEmpty()){
                curr.right = s.peek();
            }
            curr.left = null;
        }
    }

    //Morris level traversal approach
    public static void mflatten(Node node){
        Node curr= node;
        while(curr != null){
            if(curr.left != null){
                prev = curr.left;
                while(prev.right != null){
                    prev= prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }
    }
}
