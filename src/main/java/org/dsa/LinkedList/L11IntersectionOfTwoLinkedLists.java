package org.dsa.LinkedList;

public class L11IntersectionOfTwoLinkedLists {
//    https://leetcode.com/problems/intersection-of-two-linked-lists/description/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode moverA = headA;
        ListNode moverB = headB;
        while(moverA != moverB){
            moverA = moverA.next;
            moverB = moverB.next;
            if(moverA == moverB){
                return moverA;
            }
            if(moverA == null) moverA = headB;
            if(moverB == null) moverB = headA;
        }
        return moverA;
    }
}
