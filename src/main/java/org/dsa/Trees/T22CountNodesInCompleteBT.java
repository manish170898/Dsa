package org.dsa.Trees;

public class T22CountNodesInCompleteBT {
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

        System.out.println(countNodes(newRoot));
        System.out.println((2<<(2))-1);
        System.out.println(Math.pow(2,3)-1);
    }

    public static int countNodes(Node root) {
        if(root == null) return 0;
        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if(lh == rh){
            return ((2<<(lh))-1); // or you can do Math.pow(2, lh+1) -1
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private static int rightHeight(Node root) {
        int count =0;
        while(root.right != null){
            count ++;
            root = root.right;
        }
        return count;
    }

    private static int leftHeight(Node root) {
        int count =0;
        while(root.left != null){
            count ++;
            root = root.left;
        }
        return count;
    }
}
