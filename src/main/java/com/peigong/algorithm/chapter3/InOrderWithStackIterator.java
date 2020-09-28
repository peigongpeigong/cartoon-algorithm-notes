package com.peigong.algorithm.chapter3;

import java.util.Stack;

/**
 * @author: lilei
 * @create: 2020-09-27 17:26
 **/
public class InOrderWithStackIterator implements Iterator {
    @Override
    public void iterate(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.getData() + ",");
                node = node.getRight();
            }
        }
    }


    private volatile static InOrderWithStackIterator instance;

    public static InOrderWithStackIterator getInstance() {
        if (instance == null) {
            synchronized (InOrderWithStackIterator.class) {
                if (instance == null) {
                    instance = new InOrderWithStackIterator();
                }
            }
        }
        return instance;
    }
}
