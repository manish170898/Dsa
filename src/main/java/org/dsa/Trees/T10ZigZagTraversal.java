package org.dsa.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class T10ZigZagTraversal {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(zigzag(root));
    }
    public static List<List<Integer>> zigzag(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null) return ans;

        Boolean isLeftToRight = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> midList = new ArrayList<>();
            for(int i=0; i< size; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(isLeftToRight) midList.add(queue.poll().data);
                else midList.add(0,queue.poll().data);
            }
            isLeftToRight = !isLeftToRight;
            ans.add(midList);
        }
        return ans;
    }

}
