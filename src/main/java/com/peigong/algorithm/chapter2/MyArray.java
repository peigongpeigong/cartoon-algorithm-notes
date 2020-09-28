package com.peigong.algorithm.chapter2;

import java.util.Arrays;

/**
 * @author: lilei
 * @create: 2020-09-10 10:52
 **/
public class MyArray {

    private int[] array;

    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
    }

    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("超出数组实际元素范围");
        }
        if (size >= array.length) {
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出数组元素实际元素范围");
        }
        int delEle = array[index];
        int last = index;
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
            if(array[ i + 1] > 0) last++;
        }
        array[last] = 0;
        return delEle;
    }

    private void resize() {
        int[] newArr = new int[array.length << 1];
        System.arraycopy(array, 0, newArr, 0, array.length);
        this.array = newArr;
    }

    public void print(){
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        MyArray arr = new MyArray(5);
        arr.insert(0,1);
        arr.insert(1,3);
        arr.insert(2,4);
        arr.insert(3,5);
        arr.insert(1, 2);
        arr.insert(5, 6);
        arr.delete(4);
        arr.print();
    }
}
