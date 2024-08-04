package org.dsa.LinkedList;

public class L14DeleteTheMiddleNodeOfALinkedList {
//    https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

    public static void main(String[] args) {

    }
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next.next != null && fast.next.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}


