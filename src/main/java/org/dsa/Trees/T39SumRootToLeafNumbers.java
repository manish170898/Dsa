package org.dsa.Trees;

public class T39SumRootToLeafNumbers {
//    https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=daily-question&envId=2024-04-15
    public static void main(String[] args) {
    }
    public int sumNumbers(Node root) {
        int[] sum = new int[1];
        StringBuilder s = new StringBuilder();
        dfs(root, s, sum);
        return sum[0];
    }

    public void dfs(Node root, StringBuilder s, int[] sum){
        s.append(root.data);
        if(root.left == null && root.right == null){
            sum[0] += Integer.parseInt(s.toString());
            s.delete(s.length()-1, s.length());
            return;
        }
        if(root.left != null) dfs(root.left, s, sum);
        if(root.right != null) dfs(root.right, s, sum);
        s.delete(s.length()-1, s.length());
    }
}
