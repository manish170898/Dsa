package org.dsa.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T25SerializeAndDeSerialize {
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
    public String serialize(Node root) {
        if(root == null) return "";
        StringBuilder sbr = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node == null){
                sbr.append("n ");
                continue;
            }
            sbr.append(node.data).append(" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sbr.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == "") return null;
        Queue<Node> q = new LinkedList<>();
        String[] nodes = data.split(" ");
        Node root = new Node(Integer.parseInt(nodes[0]));
        q.offer(root);
        for(int i=1; i< nodes.length; i++){
            Node parent = q.poll();
            if(!nodes[i].equals("n")){
                parent.left = new Node(Integer.parseInt(nodes[i]));
                q.offer(parent.left);
            }
            if(!nodes[++i].equals("n")){
                parent.right = new Node(Integer.parseInt(nodes[i]));
                q.offer(parent.right);
            }
        }
        return root;
    }

}
