package com.peigong.algorithm.chapter3;

public interface Iterator {

    void iterate(TreeNode node);

    public static Iterator get(TreeOrderEnum mode) {
        switch (mode) {
            case PRE_MODE:
                return PreOrderIterator.getInstance();
            case IN_MODE:
                return InOrderIterator.getInstance();
            case POST_MODE:
                return PostOrderIterator.getInstance();
            case PRE_STACK_MODE:
                return PreOrderWithStackIterator.getInstance();
            case POST_STACK_MODE:
                return PostOrderWithStackIterator.getInstance();
            case IN_STACK_MODE:
                return InOrderWithStackIterator.getInstance();
            default:
                return null;
        }
    }

}
