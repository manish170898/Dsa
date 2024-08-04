package org.dsa.Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T23BTFromPreAndIn {
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

        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
    public static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i=0; i< inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        Node root = build(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, inMap);

        return root;
    }

    private static Node build(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        Node root = new Node(preorder[preStart]);

        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = build(inorder,inStart, inRoot-1, preorder, preStart +1, preStart + numsLeft, inMap);

        root.right = build(inorder, inRoot+1, inEnd, preorder, preStart+numsLeft+1, preEnd, inMap);

        return root;
    }


}
