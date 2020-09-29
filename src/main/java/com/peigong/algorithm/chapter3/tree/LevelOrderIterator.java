package com.peigong.algorithm.chapter3.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lilei
 * @create: 2020-09-29 10:53
 **/
public class LevelOrderIterator implements Iterator {
    @Override
    public void iterate(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.getData());
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    private LevelOrderIterator() {

    }
    private volatile static LevelOrderIterator instance;

    public static LevelOrderIterator getInstance() {
        if (instance == null) {
            synchronized (LevelOrderIterator.class) {
                instance = new LevelOrderIterator();
            }
        }
        return instance;
    }
}
