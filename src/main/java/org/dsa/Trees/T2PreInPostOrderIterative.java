package org.dsa.Trees;

import java.util.*;

public class T2PreInPostOrderIterative {
    public static List<Integer> preOrder(TNode root){
        Stack<TNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        stack.push(root);
        while(!stack.isEmpty()){
            if(stack.peek().right != null) stack.push(stack.peek().right);
            if(stack.peek().left != null) stack.push(stack.peek().left);
            ans.add(stack.pop().val);
        }
        return ans;
    }

    public static List<Integer> inOrder(TNode root){
        Stack<TNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }

    //2 Stack
    public static List<Integer> postOrder(TNode root){
        Stack<TNode> stack1 = new Stack<>();
        Stack<TNode> stack2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        stack1.push(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null)stack1.push(root.left);
            if(root.right != null)stack1.push(root.right);
        }
        while(!stack2.isEmpty()){
            ans.add(stack2.pop().val);
        }
        return ans;
    }

    //1 Stack
    public static List<Integer> postOrderBetter(TNode root){
        Stack<TNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TNode cur = root;
        TNode temp = null;
        while(!stack.isEmpty() || cur!= null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else {
                temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    ans.add(temp.val);
                    while (!stack.isEmpty() && stack.peek().right == temp){
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                }
                else {
                    cur = temp;
                }
            }
        }
        return ans;
    }
}
