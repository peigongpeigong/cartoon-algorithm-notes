package com.peigong.algorithm.chapter3;

import java.util.Stack;

/**
 * @author: lilei
 * @create: 2020-09-27 17:04
 **/
public class PostOrderWithStackIterator implements Iterator{
    @Override
    public void iterate(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        temp.push(node);
        while (!temp.isEmpty()) {
            node = temp.pop();
            stack.push(node);
            if (node.getLeft() != null) {
                temp.push(node.getLeft());
            }
            if (node.getRight() != null) {
                temp.push(node.getRight());
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getData() + ",");
        }
    }

    private volatile static PostOrderWithStackIterator instance;

    public static PostOrderWithStackIterator getInstance() {
        if (instance == null) {
            synchronized (PostOrderWithStackIterator.class) {
                if (instance == null) {
                    instance = new PostOrderWithStackIterator();
                }
            }
        }
        return instance;
    }
}
