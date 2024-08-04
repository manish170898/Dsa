package org.dsa.Graph;

import java.util.*;

public class G51OpenTheLock {
//    https://leetcode.com/problems/open-the-lock/description/
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        System.out.println(openLock(deadends, target));
    }
    public static int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<String>(Arrays.asList(deadends));
        if(deadend.contains("0000")){
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        int level = -1;
        queue.offer("0000");
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int j=0; j<size; j++){
                String s =  queue.poll();
                if(target.equals(s)) return level;
                for(int i=0; i<4; i++){
                    for(int delta : new int[] {-1,1}) {
                        int newDigit = (s.charAt(i) - '0' + delta + 10) % 10;
                        String newCombination = s.substring(0,i) + newDigit + s.substring(i+1);
                        if(!vis.contains(newCombination) && !deadend.contains(newCombination)){
                            vis.add(newCombination);
                            queue.offer(newCombination);
                        }
                    }
                }
            }

        }
        return -1;
    }
}
