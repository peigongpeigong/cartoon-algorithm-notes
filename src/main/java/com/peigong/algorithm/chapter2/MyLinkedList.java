package com.peigong.algorithm.chapter2;

/**
 * @author: lilei
 * @create: 2020-09-10 16:18
 **/
public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void insert(int index, T elem) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("超出链表节点范围");
        }
        Node<T> newNode = new Node<T>(elem);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else if (size == index) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }else{
            Node<T> tar = get(index);
            tar.prev.next = newNode;
            tar.prev = newNode;
            newNode.next = tar;
        }
        size++;

    }

    private Node<T> get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出链表实际范围");
        }
        Node<T> tar = head;
        while (index > 0) {
            tar = tar.next;
            index--;
        }
        return tar;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出链表实际范围");
        }
        Node<T> del = head;
        while (index > 0){
            del = del.next;
            index--;
        }
        if (del.next != null) {
            del.prev.next = del.next;
            del.next.prev = del.prev;
        }
        return del.data;
    }

    public void print(){
        if (head != null) {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Node<T> n = head;
            while (n != null) {
                builder.append(n.data).append(",");
                n = n.next;
            }
            builder.replace(builder.length() - 1,builder.length(),"]");
            System.out.println(builder.toString());
        }else{
            System.out.println("[]");
        }
    }

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> l = new MyLinkedList<>();
        l.insert(0,1);
        l.insert(1,2);
        l.insert(2,3);
        l.print();
        l.remove(1);
        l.print();
        l.insert(1, 2);
        l.print();
    }

}
