package org.dsa.Trees;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/boundary-of-binary-tree/
public class T11BoundaryTraversal {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(traverseBoundary(root));
    }

    public static List<Integer> traverseBoundary(Node root){
        List<Integer> ans = new ArrayList<>();
        if(!isLeafNode(root)) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightABoundary(root, ans);
        return ans;
    }

    private static void addLeftBoundary(Node root, List<Integer> ans) {
        Node cur = root.left;
        while (cur != null){
            if(!isLeafNode(cur)) ans.add(cur.data);
            if(cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    private static void addLeaves(Node root, List<Integer> ans) {
        if(isLeafNode(root)){
            ans.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, ans);
        if(root.right != null) addLeaves(root.right, ans);
    }

    private static void addRightABoundary(Node root, List<Integer> ans) {
        Node cur = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (cur != null){
            if (!isLeafNode(cur)) temp.add(cur.data);
            if (cur.right !=null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = temp.size()-1 ; i>=0; --i){
            ans.add(temp.get(i));
        }
    }

    private static boolean isLeafNode(Node root) {
        return root.left == null && root.right == null;
    }
}
