package org.dsa.Trees;

import java.util.ArrayList;
import java.util.List;

public class T17RootToNode {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(allRootToLeaf(root));
    }

    public static List<Integer> allRootToLeaf(Node root) {
        List<Integer> ans = new ArrayList<>();
        getPath(root, ans, 5);
        return ans;
    }

    public static boolean getPath(Node node, List<Integer> ds, int matcher){

        if(node == null){
            return false;
        }
        ds.add(node.data);
        if(node.data == matcher){
            return true;
        }

        if(getPath(node.left, ds, matcher) || getPath(node.right, ds, matcher)){
            return true;
        }

        ds.remove(ds.size()-1);
        return false;
    }

}
