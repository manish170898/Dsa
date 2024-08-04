package org.dsa.LinkedList;

import java.util.List;

public class L2MiddleOfLinkedList {
//    https://leetcode.com/problems/middle-of-the-linked-list/
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(middleNode(node));
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
