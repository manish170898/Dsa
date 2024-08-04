package org.dsa.LinkedList;

public class L8ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
//        https://leetcode.com/problems/reverse-linked-list/
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = null;
        ListNode mover = head;
        ListNode frontNode = head.next;
        while(mover != null){
            mover.next = temp;
            temp = mover;
            mover = frontNode;
            if(frontNode != null)frontNode = frontNode.next;
        }

        return temp;
    }
}
