package org.dsa.LinkedList;

public class L24CopyListWithRandomPointer {
    public static void main(String[] args) {
//        https://leetcode.com/problems/copy-list-with-random-pointer/description/
    }
//    public Node copyRandomList(Node head) {
//        if(head == null){
//            return null;
//        }
//        Node mover = head;
//        while(mover != null){
//            Node temp = mover.next;
//            mover.next = new Node(mover.val);
//            mover = mover.next;
//            mover.next = temp;
//            mover = mover.next;
//        }
//        mover = head;
//        while(mover !=  null){
//            if(mover.random == null){
//                mover.next.random = null;
//                mover = mover.next.next;
//            }
//            else{
//                mover.next.random = mover.random.next;
//                mover = mover.next.next;
//            }
//        }
//        Node newHead = head.next;
//        Node newMover = newHead;
//        mover = head;
//        while(mover != null){
//            mover.next = mover.next.next;
//            mover = mover.next;
//            if(newMover.next != null ) newMover.next = newMover.next.next;
//            else newMover.next = null;
//            newMover = newMover.next;
//        }
//        return newHead;
//    }
}
