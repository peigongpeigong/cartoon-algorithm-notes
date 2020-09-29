package com.peigong.algorithm.chapter3.tree;

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
            //后序遍历为左、右、中，所以这里放到临时栈的时候，先放左孩子
            // 这样在从临时栈弹出压入最终的栈的时候，左孩子就在上边
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

    private PostOrderWithStackIterator(){}

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
