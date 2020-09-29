package com.peigong.algorithm.chapter3.tree;

/**
 * @author: lilei
 * @create: 2020-09-27 16:10
 **/
public class PostOrderIterator implements Iterator {
    @Override
    public void iterate(TreeNode node) {
        if (node == null) {
            return;
        }
        iterate(node.getLeft());
        iterate(node.getRight());
        System.out.print(node.getData() + ",");
    }

    private PostOrderIterator(){}

    private volatile static PostOrderIterator instance;

    public static PostOrderIterator getInstance() {
        if (instance == null) {
            synchronized (PostOrderIterator.class) {
                if (instance == null) {
                    instance = new PostOrderIterator();
                }
            }
        }
        return instance;
    }
}
