package com.peigong.algorithm.chapter3;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: lilei
 * @create: 2020-09-27 15:51
 **/
public class TreeNode<E> {

    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;

    private Iterator iterator;

    public TreeNode(E e) {
        data = e;
        this.iterator = PreOrderIterator.getInstance();
    }

    public static <E> TreeNode<E> createBinaryTree(LinkedList<E> list) {
        TreeNode<E> node = null;
        if (CollectionUtils.isEmpty(list)) {
            return node;
        }
        E data = list.removeFirst();
        if (data != null) {
            node = new TreeNode<>(data);
            node.left = createBinaryTree(list);
            node.right = createBinaryTree(list);
        }
        return node;
    }

    public void iterate() {
        iterator.iterate(this);
        System.out.println();
        System.out.println("----------------");
    }

    public void setIterator(Iterator iterator) {
        this.iterator = iterator;
    }

    public E getData() {
        return data;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public static void main(String[] args) {
        LinkedList<Integer> eles = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode<Integer> root = createBinaryTree(eles);
        root.iterate();
        root.setIterator(Iterator.get(TreeOrderEnum.PRE_STACK_MODE));
        root.iterate();
        root.setIterator(Iterator.get(TreeOrderEnum.IN_MODE));
        root.iterate();
        root.setIterator(Iterator.get(TreeOrderEnum.IN_STACK_MODE));
        root.iterate();
        root.setIterator(Iterator.get(TreeOrderEnum.POST_MODE));
        root.iterate();
        root.setIterator(Iterator.get(TreeOrderEnum.POST_STACK_MODE));
        root.iterate();
    }
}
