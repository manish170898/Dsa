package org.dsa.Trees;

import java.util.*;

public class T14BottomViewOfTree {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(bottomView(root));
    }

    public static List<Integer> bottomView(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair1> queue = new LinkedList<>();

        queue.offer(new Pair1(root, 0));
        while (!queue.isEmpty()){
            Pair1 pair = queue.poll();
            Node node = pair.node;

            map.put(pair.num, node.data);

            if(node.left != null) queue.offer(new Pair1(node.left, pair.num-1));
            if(node.right != null) queue.offer(new Pair1(node.right, pair.num+1));
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
