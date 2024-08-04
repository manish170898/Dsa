package org.dsa.LinkedList;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){ this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}
}

public class reverseLinkedList {
    public static void main() {
//        reverseList(head);
    }

    public static ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head= next;
        }
        return newHead;
    }
}
