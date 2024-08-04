package org.dsa.Graph;

import java.util.*;

public class G20EventualSafeStateBfs {
    public static void main(String[] args) {

    }
    public static List<Integer> eventualSafeNodesOpt(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i< graph.length; i++){
            adjRev.add(new ArrayList<>());
        }
        // Reversing the edged in graph
        for (int i=0; i< graph.length; i++){
            for (Integer node : graph[i]){
                adjRev.get(node).add(i);
                inDegree[i]++;
            }
        }


        for(int i=0; i<graph.length; i++){
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer node = queue.peek();
            queue.remove();
            ans.add(node);
            for (Integer child: adjRev.get(node)){
                inDegree[child]--;
                if(inDegree[child] == 0){
                    queue.add(child);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
