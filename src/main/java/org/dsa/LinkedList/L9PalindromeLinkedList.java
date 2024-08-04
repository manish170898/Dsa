package org.dsa.LinkedList;

import java.util.List;

public class L9PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(0, new ListNode(0)));
        System.out.println(isPalindrome(node));
    }
//    https://leetcode.com/problems/palindrome-linked-list/

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == null){
            return true;
        }
        if(head.next.next == null){
            return head.val == head.next.val;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = null;
        ListNode start = slow.next;
        ListNode front = slow.next.next;

        while(start != null){
            start.next = temp;
            temp = start;
            start = front;
            if(front != null) front = front.next;
        }

        while(temp != null){
            if(temp.val != head.val){
                return false;
            }
            temp = temp.next;
            head = head.next;
        }
        return true;
    }
}
