package org.dsa.Trees;

import java.util.HashMap;
import java.util.Map;

public class T24BTFromPostAndIn {
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


    public static Node buildTree(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i=0; i< inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        Node root = build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);

        return root;
    }

    private static Node build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        Node root = new Node(postorder[postEnd]);

        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = build(inorder,inStart, inRoot-1, postorder, postStart, postStart + numsLeft-1, inMap);

        root.right = build(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inMap);

        return root;
    }

}
