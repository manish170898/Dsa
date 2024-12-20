package org.dsa.LinkedList;

public class L21Merge2SortedLL {
//    https://leetcode.com/problems/merge-two-sorted-lists/description/
    public static ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val > list2.val){
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode res = list1;
        while(list1 != null && list2 != null){
            ListNode tmp = null;
            while(list1 != null && list1.val <= list2.val){
                tmp = list1;
                list1 = list1.next;
            }
            tmp.next = list2;

            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        return res;
    }
}
