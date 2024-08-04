package org.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G17CycleInDirectedGraphBfs {
    public static void main(String[] args) {

    }
// Intuition is we try KHans algorithm but if it does not product V elemnts then topological sort is not happening that means we have a loop somewhere.
    static boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[V];

        for(int i=0; i<V; i++){
            for (Integer node: adj.get(i)){
                inDegree[node]++;
            }
        }
        for(int i=0; i<V; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int i=0;
        while (!queue.isEmpty()){
            Integer node = queue.remove();
            ans[i++]= node;
            for (Integer child: adj.get(node)){
                inDegree[child]--;
                if(inDegree[child] == 0){
                    queue.add(child);
                }
            }
        }
        if(i != V){
            return true;
        }
        return false;
    }
}
