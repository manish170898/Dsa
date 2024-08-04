package org.dsa.LinkedList;

public class L20RotateList {
    public static void main(String[] args) {
//        https://leetcode.com/problems/rotate-list/
        ListNode node = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotateRight(node, 2);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        int count = 1;
        while(tail.next != null){
            count ++;
            tail = tail.next;
        }
        k = k % count;
        if(k ==0){
            return head;
        }
        else{
            ListNode fast = head;
            ListNode slow = head;
            for(int i=0; i<=k; i++){
                fast = fast.next;
            }
            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            tail.next = head;
            head = slow.next;
            slow.next = null;

        }
        return head;
    }
}
