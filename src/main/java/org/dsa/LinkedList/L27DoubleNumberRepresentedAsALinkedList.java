package org.dsa.LinkedList;

public class L27DoubleNumberRepresentedAsALinkedList {
//    https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/?envType=daily-question&envId=2024-05-07
    public ListNode doubleIt(ListNode head) {
        ListNode mover = head;
        int carry = recDouble(mover);
        if(carry == 1){
            ListNode nHead = new ListNode(1);
            nHead.next= head;
            head = nHead;
        }
        return head;
    }

    public int recDouble(ListNode node){
        if(node == null){
            return 0;
        }
        int carry = recDouble(node.next);
        int val = node.val + node.val + carry;
        if(val > 9){
            node.val = val%10;
            return 1;
        }
        else{
            node.val = val;
            return 0;
        }
    }
}
