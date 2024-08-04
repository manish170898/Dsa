package org.dsa.Trees;

import java.util.ArrayList;
import java.util.List;

public class T26MorrisTraversal {
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

        System.out.println(morrisIn(root));
        System.out.println(morrisIn(newRoot));
        System.out.println(morrisPre(root));
        System.out.println(morrisPre(newRoot));

    }

    public static List<Integer> morrisIn(Node root){
        List<Integer> list = new ArrayList<>();
        Node cur = root;
        while(cur != null){
            if(cur.left == null){
                list.add(cur.data);
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
                    list.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return list;
    }

    public static List<Integer> morrisPre(Node root){
        List<Integer> list = new ArrayList<>();
        Node cur = root;
        while(cur != null){
            if(cur.left == null){
                list.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    list.add(cur.data);
                    cur= cur.left;
                }
                else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return list;
    }

}
