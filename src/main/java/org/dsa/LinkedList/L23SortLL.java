package org.dsa.LinkedList;

public class L23SortLL {
    public static void main(String[] args) {
//        https://leetcode.com/problems/sort-list/
        ListNode node = new ListNode(4,new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5)))));
        sortList(node);
    }
    public static ListNode sortList(ListNode head) {

        return mergeSort(head);
    }
    public static ListNode mergeSort(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode middle = middleNode(node);
        ListNode leftHead = node;
        ListNode rightHead = middle.next;
        middle.next = null;

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        return merge(leftHead, rightHead);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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
