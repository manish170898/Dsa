package org.dsa.StackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S2RevealCardsInIncreasingOrder {
    public static void main(String[] args) {

    }
//    https://leetcode.com/problems/reveal-cards-in-increasing-order/?envType=daily-question&envId=2024-04-11

    // here we try to simulate the  steps in the question not on the values but on the indexx ...
    // we initially put all the indexes in the queue and then we apply the given algorithm we take one and put another at the end ...
    // so if we take a iun dex we put the elemnt of sorted deck there. ... if we dont take we pushback into the queue.
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[deck.length];
        Arrays.sort(deck);
        for(int i=0; i<deck.length; i++){
            queue.offer(i);
        }
        int i=0;
        boolean take = true;
        while(!queue.isEmpty()){
            Integer index = queue.remove();
            if(take){
                ans[index] = deck[i];
                i++;
                take = false;
            }
            else{
                take = true;
                queue.offer(index);
            }
        }
        return ans;
    }
}
