package org.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule/description/
public class G18CourseSchedule1 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            for (Integer node: adj.get(i)){
                inDegree[node]++;
            }
        }
        for(int i=0; i<numCourses; i++){
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
        if(i != numCourses){
            return false;
        }
        return true;
    }
}
