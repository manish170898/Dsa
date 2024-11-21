package org.dsa.LinkedList;

public class L29ReverseALinkedListUsingRecursion {
//    https://www.geeksforgeeks.org/recursively-reversing-a-linked-list-a-simple-implementation/
    // Complete the reverse function below.
    static Node reverse(Node head) {
        if(head == null) {
            return head;
        }

        // last node or only one node
        if(head.next == null) {
            return head;
        }

        Node newHeadNode = reverse(head.next);

        // change references for middle chain
        head.next.next = head;
        head.next = null;

        // send back new head node in every recursion
        return newHeadNode;
    }
}
