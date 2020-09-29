package com.peigong.algorithm.chapter3.tree;

import java.util.Stack;

/**
 * @author: lilei
 * @create: 2020-09-27 16:26
 **/
public class PreOrderWithStackIterator implements Iterator {
    @Override
    public void iterate(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.getData() + ",");
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    private PreOrderWithStackIterator(){}

    private volatile static PreOrderWithStackIterator instance;

    public static PreOrderWithStackIterator getInstance() {
        if (instance == null) {
            synchronized (PreOrderWithStackIterator.class) {
                if (instance == null) {
                    instance = new PreOrderWithStackIterator();
                }
            }
        }
        return instance;
    }
}
