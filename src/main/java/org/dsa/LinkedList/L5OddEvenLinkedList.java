package org.dsa.LinkedList;

public class L5OddEvenLinkedList {
//    https://leetcode.com/problems/odd-even-linked-list/description/
    public static void main(String[] args) {

    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode oddMover = oddHead;
        ListNode evenMover = evenHead;

        while(oddMover != null && evenMover != null && oddMover.next != null && evenMover.next != null){
            oddMover.next = oddMover.next.next;
            oddMover = oddMover.next;
            evenMover.next = evenMover.next.next;
            evenMover = evenMover.next;
        }
        oddMover.next = evenHead;
        return oddHead;
    }
}
