package com.peigong.algorithm.chapter2;

import java.util.Arrays;

/**
 * @author: lilei
 * @create: 2020-09-11 10:47
 **/
public class MyStack<E> {

    private Object[] array;
    private int cursor;

    public MyStack(int capacity){
        this.array = new Object[capacity];
    }

    public void push(E e) {
        array[cursor++] = e;
    }

    public E pop(){
        E e = (E)array[--cursor];
        array[cursor] = null;
        return e;
    }

    public void print(){
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>(10);
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.print();
        System.out.println("pop:" + ms.pop());
        ms.print();
    }

}
