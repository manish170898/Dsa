package org.dsa.Trees;

public class T38SumOfLeftLeaves {
//    https://leetcode.com/problems/sum-of-left-leaves/description/
    public int sumOfLeftLeaves(Node root) {
        return find_val(root,1);
    }

    public static int find_val(Node root,int flag){
        if(root==null) return 0;
        if(flag==0&&root.right==null&&root.left==null) return root.data;
        return find_val(root.left,0)+find_val(root.right,1);
    }
}
