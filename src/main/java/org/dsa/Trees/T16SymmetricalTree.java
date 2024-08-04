package org.dsa.Trees;

public class T16SymmetricalTree {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(Node root) {
        return root == null || isSymmetricHelp(root.right, root.left);
    }

    private static boolean isSymmetricHelp(Node right, Node left) {
        if(right == null || left == null){
            return right == left;
        }

        if(right.data != left.data){
            return false;
        }

        return isSymmetricHelp(right.right, left.left) && isSymmetricHelp(right.left, left.right);
    }
}
