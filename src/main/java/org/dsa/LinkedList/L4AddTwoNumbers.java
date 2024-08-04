package org.dsa.LinkedList;

public class L4AddTwoNumbers {
//    https://leetcode.com/problems/add-two-numbers/description/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode newList = new ListNode(-1);
        ListNode curr = newList;
        int sum = 0;
        while(l1 != null || l2 != null){
            sum = carry;
            if(l1!= null) {sum+= l1.val; l1 = l1.next;}
            if(l2!= null) {sum+= l2.val; l2 = l2.next;}
            if(sum >= 10){
                sum = sum %10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;


        }

        if(carry == 1){
            curr.next = new ListNode(carry);
        }
        newList = newList.next;
        return newList;
    }
}
