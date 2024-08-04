package org.dsa.LinkedList;

public class L1DeleteNodeInALinkedList {
//    https://leetcode.com/problems/delete-node-in-a-linked-list/description/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
