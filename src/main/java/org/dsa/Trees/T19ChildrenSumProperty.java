package org.dsa.Trees;

public class T19ChildrenSumProperty {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        childrenSumProperty(root);
    }

    public static void childrenSumProperty(Node node){

        if (node == null){
            return;
        }
        int cur=0;
        if(node.left != null){
            cur = cur +node.left.data;
        }
        if(node.right != null){
            cur = cur +node.right.data;
        }
        if(cur >= node.data){
            node.data = cur;
        }
        else {
            if(node.left != null) node.left.data = node.data;
            else if(node.right != null) node.right.data = node.data;
        }

        childrenSumProperty(node.left);
        childrenSumProperty(node.right);

        int total =0 ;
        if(node.left != null){
            total = total +node.left.data;
        }
        if(node.right != null){
            total = total +node.right.data;
        }
        if(node.left != null || node.right!=null) node.data=total;

    }
}
