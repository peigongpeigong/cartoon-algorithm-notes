package com.peigong.algorithm.chapter3;

/**
 * @author: lilei
 * @create: 2020-09-27 16:09
 **/
public class InOrderIterator implements Iterator {
    @Override
    public void iterate(TreeNode node) {
        if (node == null) {
            return;
        }
        iterate(node.getLeft());
        System.out.print(node.getData() + ",");
        iterate(node.getRight());
    }

    private volatile static InOrderIterator instance;

    public static InOrderIterator getInstance() {
        if (instance == null) {
            synchronized (InOrderIterator.class) {
                if (instance == null) {
                    instance = new InOrderIterator();
                }
            }
        }
        return instance;
    }
}
