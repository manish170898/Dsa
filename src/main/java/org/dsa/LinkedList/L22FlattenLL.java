package org.dsa.LinkedList;

public class L22FlattenLL {
    public static void main(String[] args) {
//        https://www.naukri.com/code360/problems/flatten-a-linked-list_1112655?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
    }

//    public static Node flattenLinkedList(Node head) {
//        if(head. next == null || head == null){
//            return head;
//        }
//        //Write your code here
//        Node mover = head;
//        Node res = merge(mover, mover.next);
//        mover = mover.next.next;
//        res.next = null;
//        while(mover != null){
//            res = merge(res, mover);
//            mover = mover.next;
//            res.next = null;
//        }
//        return res;
//    }
//    public static Node merge(Node list1, Node list2){
//        if(list1 == null) return list2;
//        if(list2 == null) return list1;
//        if(list1.data > list2.data){
//            Node temp = list1;
//            list1 = list2;
//            list2 = temp;
//        }
//        Node res = list1;
//        while(list1 != null && list2 != null){
//            Node tmp = null;
//            while(list1 != null && list1.data <= list2.data){
//                tmp = list1;
//                list1 = list1.child;
//            }
//            tmp.child = list2;
//
//            Node temp = list1;
//            list1 = list2;
//            list2 = temp;
//        }
//        return res;
//    }

}
