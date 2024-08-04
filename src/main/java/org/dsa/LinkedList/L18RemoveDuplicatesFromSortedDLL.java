package org.dsa.LinkedList;

public class L18RemoveDuplicatesFromSortedDLL {
//    https://www.naukri.com/code360/problems/remove-duplicates-from-a-sorted-doubly-linked-list_2420283?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public static NodeDLL uniqueSortedList(NodeDLL head) {
    // Write your code here.
    if(head == null || head.next == null){
        return head;
    }

    NodeDLL mover = head;
    NodeDLL moverNext = head.next;
    while(moverNext != null){
        if(mover.data == moverNext.data){
            mover.next = moverNext.next;
            if(moverNext.next != null){
                moverNext.next.prev = mover;
            }
            moverNext.prev = null;
            moverNext.next = null;
            moverNext = mover.next;
        }
        else{
            mover = moverNext;
            moverNext = moverNext.next;
        }
    }
    return head;
}
}
