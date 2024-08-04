package org.dsa.Trees;

import java.sql.Struct;
import java.util.*;

public class T20NodeAtaDistanceK {
    public static void main(String[] args20) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

//        distanceK(root);
    }

    public List<Integer> distanceK(Node root, Node target, int k){
        Map<Node, Node> parentTrack = new HashMap<>();
        markParents(root, parentTrack);
        List<Integer> ans = new ArrayList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int currLevel = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(currLevel == k) break;
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
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            ans.add(cur.data);
        }
        return ans;
    }

    private void markParents(Node root, Map<Node, Node> parentTrack) {
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

