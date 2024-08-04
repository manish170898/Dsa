package org.dsa.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/find-eventual-safe-states/description/
public class G14EventualSafeStateDfs {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        eventualSafeNodes(arr);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safe = new ArrayList<>();
        List<Integer> notSafe = new ArrayList<>();
        int[] vis = new int[graph.length];
        int[] visPath = new int[graph.length];

        for(int i=0; i< graph.length; i++){
            if(vis[i] == 0){
                List<Integer> nondeterministic = new ArrayList<>();
                if(!safeDfs(i, vis, visPath, graph, nondeterministic, safe)){
                    safe.addAll(nondeterministic);
                }
                else {
                    notSafe.addAll(nondeterministic);
                }
            }
        }
        safe.removeAll(notSafe);
        Collections.sort(safe);
        return safe;
    }

    private static boolean safeDfs(int i, int[] vis, int[] visPath, int[][] graph, List<Integer> nondeterministic, List<Integer> safe) {
        nondeterministic.add(i);
        vis[i] = 1;
        visPath[i] = 1;
        for (Integer node: graph[i]){
            if(vis[node] == 0){
                if(safeDfs(node,vis,visPath,graph,nondeterministic, safe)) return true;
                else {safe.add(node);
                nondeterministic.remove(nondeterministic.size()-1);}
            }
            else if(visPath[node] == 1){
                return true;
            }
        }
        visPath[i] = 0;
        return false;
    }


    //Optimized Solution
    //Striver Way

    public static List<Integer> eventualSafeNodesOpt(int[][] graph) {
        int[] check = new int[graph.length];
        int[] vis = new int[graph.length];
        int[] visPath = new int[graph.length];
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i< graph.length; i++){
            if(vis[i] == 0){
                safeDfsOpt(i, vis, visPath, graph, check);
            }
        }

        for(int i=0; i<graph.length; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }

    private static boolean safeDfsOpt(int i, int[] vis, int[] visPath, int[][] graph, int[] check) {
        vis[i] = 1;
        visPath[i] = 1;
        check[i] = 0;
        for (Integer node: graph[i]){
            if(vis[node] == 0){
                if(safeDfsOpt(node,vis,visPath,graph,check)) return true;
            }
            else if(visPath[node] == 1){
                return true;
            }
        }
        check[i] = 1;
        visPath[i] = 0;
        return false;
    }
}
