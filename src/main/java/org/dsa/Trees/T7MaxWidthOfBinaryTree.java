package org.dsa.Trees;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class T7MaxWidthOfBinaryTree {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(maxWidthOfBinaryTree(root));
    }

    public static int maxWidthOfBinaryTree(Node root){
        Queue<Pair1> queue = new LinkedList<Pair1>();
        int ans = 0;
        if(root == null) return 0;
        queue.offer(new Pair1(root, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int mmin = queue.peek().num;
            int first = 0, last =0;
            for(int i=0; i< size; i++){
                int cur_id = queue.peek().num - mmin;
                Node node = queue.peek().node;
                queue.poll();
                if(i==0) first = cur_id;
                if (i == size-1) last = cur_id;
                if(node.left != null) queue.offer(new Pair1(node.left,cur_id*2 +1));
                if(node.right != null) queue.offer(new Pair1(node.right, cur_id*2 +2));
            }
            ans = Math.max(ans, last - first +1);
        }
        return ans;
    }
}
