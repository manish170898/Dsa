package org.dsa.Trees;

import java.util.*;
import java.util.stream.Collectors;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}


public class A0TreesTraversalAll {
    public static void main(String[] args20){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.right.left = new Node(8);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);

        // PRE ORDER
            // RECURSIVE
        System.out.print("preOderRecursive: ");
        preOrderPrint(root);
        System.out.println();
            // ITERATIVE
        System.out.print("preOderIterative: ");
        System.out.println(preOrderIterativeTraversal(root).stream().collect(Collectors.toList()));
        System.out.println();


        // IN ORDER
            // RECURSIVE
        System.out.print("inOderRecursive: ");
        inOrderTraversal(root);
        System.out.println();
            // ITERATIVE
        System.out.print("inOderIterative: ");
        System.out.println(inOrderIterativeTraversal(root).stream().collect(Collectors.toList()));
        System.out.println();

        // POST ORDER
            // RECURSIVE
        System.out.print("postOderRecursive: ");
        postOrderTraversal(root);
        System.out.println();
            // ITERATIVE
        System.out.print("postOderIterative: ");
        System.out.println(" Way1: " + postOrderIterativeTraversal(root).stream().collect(Collectors.toList()));
        System.out.println();
        System.out.println(" Way2: " + postOrderIterativeTraversal2(root).stream().collect(Collectors.toList()));

        // LEVEL ORDER
        levelOrderTraversal(root);

    }

    public static void preOrderPrint(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+ " ");
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    public static void inOrderTraversal(Node node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(Node node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static List<List<Integer>> levelOrderTraversal(Node node){
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(node == null) return wrapList;
        queue.offer(node);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    // USE STACK
    public static List<Integer> preOrderIterativeTraversal(Node node){
        List<Integer> preOrder = new ArrayList<Integer>();
        if(node == null) return preOrder;
        Stack<Node> st = new Stack<Node>();
        st.push(node);
        while(!st.isEmpty()){
            node = st.pop();
            preOrder.add(node.data);
            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        return preOrder;
    }
    public static List<Integer> inOrderIterativeTraversal(Node root){
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();
        Node node = root;
        while (true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else {
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }

    // Using 2 stacks
    public static List<Integer> postOrderIterativeTraversal(Node node){
        List<Integer> postOrder = new ArrayList<Integer>();
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();

        if(node == null){
            return postOrder;
        }
        st1.push(node);
        while (!st1.isEmpty()){
            node = st1.pop();
            st2.add(node);
            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }
        while (!st2.isEmpty()){
            postOrder.add(st2.pop().data);
        }
        return postOrder;
    }


    // Using 1 stack
    public static List<Integer> postOrderIterativeTraversal2(Node node){
        List<Integer> postOrder = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();

        Node curr = node;
        Node temp;
        while(!st.isEmpty() || curr != null){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else {
                temp = st.peek().right;
                if(temp == null){
                    temp = st.peek();
                    st.pop();
                    postOrder.add(temp.data);
                    while (! st.isEmpty() && temp == st.peek().right){
                        temp = st.peek();
                        st.pop();
                        postOrder.add(temp.data);
                    }
                }
                else {
                    curr = temp;
                }
            }
        }

        return postOrder;
    }
}
