package org.dsa.Trees;

import java.util.*;


class Tuple{
    Node node;
    int verticalOrder;
    int level;
    public Tuple(Node node, int verticalOrder, int level) {
        this.node = node;
        this.verticalOrder = verticalOrder;
        this.level = level;
    }
}
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class T12VerticalOrderTraversal {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        System.out.println(verticalTraversal(root));
    }


    public static List<List<Integer>> verticalTraversal(Node root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            Node node = tuple.node;

            int verticalOrder = tuple.verticalOrder;
            int level = tuple.level;

            if(!map.containsKey(verticalOrder)){
                map.put(verticalOrder, new TreeMap<>());
            }
            if(!map.get(verticalOrder).containsKey(level)){
                map.get(verticalOrder).put(level, new PriorityQueue<>());
            }
            map.get(verticalOrder).get(level).offer(node.data);

            if(node.left != null) queue.offer(new Tuple(node.left, --verticalOrder, ++level));
            if(node.right != null) queue.offer(new Tuple(node.right, ++verticalOrder, ++level));
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> finalMap : map.values()){
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : finalMap.values()){
                while (!pq.isEmpty()){
                    list.get(list.size()-1).add(pq.poll());
                }
            }
        }

        return list;
    }
}
