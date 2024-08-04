package org.dsa.Trees;

public class T41SmallestStringStartingFromLeaf {
//    https://leetcode.com/problems/smallest-string-starting-from-leaf/description/
    public static void main(String[] args) {
        Node node = new Node(25);
        node.left =new Node(1);
        node.right =new Node(3);
        node.left.left =new Node(1);
        node.left.right =new Node(3);
        node.right.left =new Node(0);
        node.right.right =new Node(2);

        smallestFromLeaf(node);
    }

    public static String smallestFromLeaf(Node root) {
        StringBuilder sb = new StringBuilder();
        String[] lowestString = new String[1];
        lowestString[0] = "";
        dfs(root, sb, lowestString);
        return lowestString[0];
    }
    public static void dfs(Node root, StringBuilder sb, String[] lowestString){
        sb.append((char)(root.data + 97));
        if(root.left == null && root.right == null){
            if(lowestString[0] == ""){
                lowestString[0] = sb.reverse().toString();
                sb.reverse();
                sb.delete(sb.length()-1, sb.length());
                return;
            }
            else{
                if(lowestString[0].compareTo(sb.reverse().toString()) > 0){
                    lowestString [0]= sb.toString();
                    sb.reverse();
                    sb.delete(sb.length()-1, sb.length());
                    return;
                }
                sb.reverse();
            }
        }
        if(root.left != null) {dfs(root.left, sb, lowestString);}
        if(root.right != null) {dfs(root.right, sb, lowestString);}
        sb.delete(sb.length()-1, sb.length());
    }
}
