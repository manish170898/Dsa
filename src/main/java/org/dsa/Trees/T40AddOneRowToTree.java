package org.dsa.Trees;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/add-one-row-to-tree/
public class T40AddOneRowToTree {
    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(6);
        node.left.left = new Node(3);
        node.left.right = new Node(1);
        node.right.left = new Node(5);
        addOneRow(node, 1, 1);
    }
    public static Node addOneRow(Node root, int val, int depth) {
        if(depth == 1){
            Node newRoot = new Node(val);
            newRoot.left = root;
            return newRoot;
        }
        int level = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(true){
            int size = q.size();
            level++;
            if(level == depth -1){
                for(int i=0; i<size; i++){
                    Node n = q.remove();
                    Node tempLeft = n.left;
                    Node tempRight = n.right;
                    n.left = new Node(val);
                    n.right = new Node(val);
                    n.left.left = tempLeft;
                    n.right.right = tempRight;
                }
                return root;
            }
            else{
                for(int i=0; i<size; i++){
                    Node n = q.remove();
                    if(n.left != null) q.offer(n.left);
                    if(n.right != null) q.offer(n.right);
                }
            }
        }
    }
}
