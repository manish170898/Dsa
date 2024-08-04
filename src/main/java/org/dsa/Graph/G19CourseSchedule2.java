package org.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii/submissions/1216318599/
public class G19CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i< numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            for (Integer node: adjList.get(i)){
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
            for (Integer child: adjList.get(node)){
                inDegree[child]--;
                if(inDegree[child] == 0){
                    queue.add(child);
                }
            }
        }
        if(i != numCourses){
            return new int[]{};
        }
        return ans;
    }
}
