package org.dsa.Trees;

import java.util.ArrayList;
import java.util.List;

public class T15LeftRightViewOfTree {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        List<Integer> resultleft = new ArrayList<>();
        List<Integer> resultright = new ArrayList<>();
        leftView(root, resultleft, 0);
        rightView(root, resultright, 0);
        System.out.println();
        System.out.println();
    }


    public static void leftView(Node root, List<Integer> res, int depth)
    {
        // Your code here
        if (root == null){
            return;
        }
        if(depth == res.size()){
            res.add(root.data);
        }
        if(root.left != null) leftView(root.left, res, depth +1);
        if(root.right != null) leftView(root.right, res, depth +1);
    }

    public static void rightView(Node root, List<Integer> res, int depth)
    {
        // Your code here

        if (root == null){
            return;
        }
        if(depth == res.size()){
            res.add(root.data);
        }
        if(root.right != null) leftView(root.right, res, depth +1);
        if(root.left != null) leftView(root.left, res, depth +1);
    }
}
