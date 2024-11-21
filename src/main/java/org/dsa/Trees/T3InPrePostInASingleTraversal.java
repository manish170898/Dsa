package org.dsa.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair1{
    Node node;
    Integer num;

    Pair1(Node node, Integer num){
        this.node = node;
        this.num = num;
    }

}
public class T3InPrePostInASingleTraversal {
    public static void main(String[] args){

    }

    public static void inPrePost(Node node){
        Stack<Pair1> stack = new Stack<>();
        stack.push(new Pair1(node,1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while(!stack.isEmpty()){
            Pair1 pair = stack.pop();

            if(pair.num == 1){
                pre.add(pair.node.data);
                pair.num++;
                stack.push(pair);
                if (pair.node.left != null){
                    stack.push(new Pair1(pair.node.left, 1));
                }
            }
            if(pair.num == 2){
                in.add(pair.node.data);
                pair.num++;
                stack.push(pair);
                if (pair.node.right != null){
                    stack.push(new Pair1(pair.node.right, 1));
                }
            }
            if(pair.num == 3){
                post.add(pair.node.data);
            }
        }
    }
}
