package org.dsa.LinkedList;

public class L7RemoveNthNodeFromEnd {
    public static void main(String[] args) {
//        https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode start = new ListNode();
        start.next =head;
        ListNode fast = start;
        ListNode slow = start;

        for(int i=0; i<=n; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }


        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
