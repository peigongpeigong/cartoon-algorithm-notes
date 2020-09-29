package com.peigong.algorithm.chapter3.tree;

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
            //中序遍历为左、父、右
            //一直向下找左孩子并压入栈
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                //弹出最新压入的节点，第一次为最下层最左侧的叶子节点
                //弹出并输出值
                node = stack.pop();
                System.out.print(node.getData() + ",");
                node = node.getRight();
            }
        }
    }

    private InOrderWithStackIterator(){}

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
