package org.dsa.Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class A30LastStoneWeight {
//    https://leetcode.com/problems/last-stone-weight/description/
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer stone: stones){
            pq.offer(stone);
        }

        while(pq.size() != 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            pq.offer(stone1-stone2);
        }

        return pq.poll();
    }
}
