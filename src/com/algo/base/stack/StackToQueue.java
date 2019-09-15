package com.algo.base.stack;

import com.algo.base.list.Node;

import java.util.Stack;

/**
 * Created by geng
 * on 2017/9/26.
 * <p>
 * 用2个栈，实现队列
 */
public class StackToQueue {

    public static Stack<Node> stack1 = new Stack<>();
    public static Stack<Node> stack2 = new Stack<>();

    public static void main(String[] args) {
        add(new Node("1"));
        add(new Node("2"));
        add(new Node("3"));
        add(new Node("4"));
        add(new Node("5"));
        add(new Node("6"));


        System.out.println(poll().value);
        System.out.println(poll().value);
        System.out.println(poll().value);
        System.out.println(poll().value);
        System.out.println(poll().value);
        System.out.println(poll().value);
    }

    public static void add(Node node) {
        stack1.push(node);
    }

    public static Node poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // 如果弹出栈中还没有数据就抛出异常
        if (stack2.isEmpty()) {
            throw new RuntimeException("No more element.");
        }
        return stack2.pop();
    }
}
