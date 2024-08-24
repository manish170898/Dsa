package org.dsa.Arrays;

public class A28TimeNeededToBuyTickets {
    public static void main(String[] args) {
//        https://leetcode.com/problems/time-needed-to-buy-tickets/
    }

    public int normalSolution(int[] tickets, int k){
        int[] time = new int[tickets.length];
        int count = 0;

        while(true){
            for(int i=0; i<tickets.length; i++){
                if(tickets[i] != 0){
                    tickets[i] = tickets[i]-1;
                    count ++;
                    time[i] = count;
                }
                if(tickets[k] == 0){
                    return time[k];
                }
            }
        }
    }
    public int optimalSolution(int[] tickets, int k){
        int time = 0;
        for(int i=0; i<tickets.length; i++){
            if(i <= k){
                time = time + Math.min(tickets[k], tickets[i]);
            }
            else{
                time = time + Math.min(tickets[k]-1, tickets[i]);
            }
        }
        return time;
    }
}
