package org.dsa.LinkedList;

import java.util.ArrayList;

public class L17FindPairsWithGivenSumDLL {

//    https://www.naukri.com/code360/problems/find-pairs-with-given-sum-in-doubly-linked-list_1164172?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

    public static  ArrayList<int[]>  findPairs(NodeDLL head, int k) {
        // Write your code here.\
        ArrayList <int[]> li=new ArrayList<>() ;
        NodeDLL tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        while(head.data < tail.data){
            if((head.data + tail.data) == k){
                int[] pair={head.data,tail.data};
                li.add(pair);
                head=head.next;
                tail=tail.prev;
            }
            else if((head.data + tail.data) > k){
                tail = tail.prev;
            }
            else{
                head = head.next;
            }
        }
        return li;
    }
}


