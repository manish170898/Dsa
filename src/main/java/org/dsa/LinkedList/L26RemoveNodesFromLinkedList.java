package org.dsa.LinkedList;

public class L26RemoveNodesFromLinkedList {
//    https://leetcode.com/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-05-06
    public ListNode removeNodes(ListNode head) {
        ListNode mover = head;
        ListNode prev = null;
        ListNode nxt = head.next;

        while(mover != null){
            mover.next = prev;
            prev = mover;
            mover = nxt;
            if(nxt != null) nxt = nxt.next;
        }


        ListNode maxTillNow = prev;
        mover = prev.next;
        maxTillNow.next = null;
        while(mover != null){
            if(mover.val >= maxTillNow.val){
                ListNode temp = mover.next;
                mover.next = maxTillNow;
                maxTillNow = mover;
                mover = temp;
            }
            else{
                mover = mover.next;
            }
        }
        return maxTillNow;
    }
}
