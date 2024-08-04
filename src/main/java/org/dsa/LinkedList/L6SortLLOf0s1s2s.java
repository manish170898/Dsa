package org.dsa.LinkedList;

public class L6SortLLOf0s1s2s {
    public static void main(String[] args) {
        Node node = new Node(1,new Node(0, new Node(2, new Node(1, new Node(0)))));

        sortList(node);
    }
//    https://www.naukri.com/code360/problems/sort-linked-list-of-0s-1s-2s_1071937?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
    public static Node sortList(Node head) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }
        Node zerosHead = new Node(-1);
        Node zerosMover = zerosHead;
        Node onesHead = new Node(-1);
        Node onesMover = onesHead;
        Node twosHead = new Node(-1);
        Node twosMover = twosHead;

        Node mover  = head;

        while(mover != null){
            if(mover.data == 0){
                zerosMover.next = mover;
                zerosMover = zerosMover.next;
            }
            if(mover.data == 1){
                onesMover.next = mover;
                onesMover = onesMover.next;
            }
            if(mover.data == 2){
                twosMover.next = mover;
                twosMover = twosMover.next;
            }
            mover = mover.next;
        }
        zerosMover.next = onesHead.next == null ? twosHead.next : onesHead.next;
        onesMover.next = twosHead.next;
        zerosHead = zerosHead.next;
        twosMover.next = null;
        return zerosHead;
    }
}

class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
