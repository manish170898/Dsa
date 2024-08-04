package org.dsa.Trees;

import java.util.*;

public class T21MinimumTimeTakenToBurnBT {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        minTime(root, 8);
    }

    public static int minTime(Node root, int target)
    {
        Node targetN= search(root, target);
        Map<Node, Node> parentTrack = new HashMap<>();
        markParents(root, parentTrack);
        List<Integer> ans = new ArrayList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(targetN);
        int currLevel = -1;
        visited.put(targetN, true);
        while(!queue.isEmpty()){
            int size = queue.size();
            currLevel ++;
            for(int i=0; i<size; i++){
                Node current = queue.poll();
                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null){
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }
        return currLevel;
    }

    private static Node search(Node node, int target){
        if(node != null){
            if(node.data == target){
                return node;
            } else {
                Node foundNode = search(node.left, target);
                if(foundNode == null) {
                    foundNode = search(node.right, target);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }


    private static void markParents(Node root, Map<Node, Node> parentTrack) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left !=null){
                parentTrack.put(cur.left, cur);
                queue.offer(cur.left);
            }
            if(cur.right !=null){
                parentTrack.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }
    }
}
