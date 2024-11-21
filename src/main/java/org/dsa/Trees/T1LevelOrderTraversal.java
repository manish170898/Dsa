package org.dsa.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 class TNode {
     int val;
     TNode left;
     TNode right;
     TNode() {}
     TNode(int val) { this.val = val; }
     TNode(int val, TNode left, TNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

    public class T1LevelOrderTraversal {
    public static void main(String[] args){

    }

    public static List<List<Integer>> level(TNode root){
        Queue<TNode> queue = new LinkedList<TNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> midList = new ArrayList<>();
            for(int i=0; i< size; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                midList.add(queue.poll().val);
            }
            ans.add(midList);
        }
        return ans;
    }
}
