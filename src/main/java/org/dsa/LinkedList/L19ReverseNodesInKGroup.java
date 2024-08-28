package org.dsa.LinkedList;

public class L19ReverseNodesInKGroup {
//    https://leetcode.com/problems/reverse-nodes-in-k-group/description/

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node1 = new ListNode(1,new ListNode(2));
        reverseKGroup(node, 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode cTail = null;
        while(temp!= null){
            ListNode cHead = temp;
            for(int i=0; i<k; i++){
                temp = temp.next;
                if(temp == null){
                    if(i != k-1){
                        cTail.next = cHead;
                        return head;
                    }
                }
            }
            ListNode mover = cHead;
            ListNode moverNext = cHead.next;
            ListNode toBeHead = null;
            for(int i=0; i<k; i++){
                mover.next = toBeHead;
                toBeHead = mover;
                mover = moverNext;
                if(moverNext != null)moverNext = moverNext.next;
            }
            if(cHead == head){
                head = toBeHead;
            }
            else{
                cTail.next = toBeHead;
            }
            cTail = cHead;
        }
        return head;
    }
}
