package com.peigong.algorithm.chapter3.tree;

/**
 * @author: lilei
 * @create: 2020-09-27 16:07
 **/
public class PreOrderIterator implements Iterator {

    @Override
    public void iterate(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + ",");
        iterate(node.getLeft());
        iterate(node.getRight());
    }

    private PreOrderIterator(){}

    private volatile static PreOrderIterator instance;

    public static PreOrderIterator getInstance() {
        if (instance == null) {
            synchronized (PreOrderIterator.class) {
                if (instance == null) {
                    instance = new PreOrderIterator();
                }
            }
        }
        return instance;
    }
}
