package com.peigong.algorithm.chapter3.heap;

import java.util.Arrays;

/**
 * 最大堆
 * @author: lilei
 * @create: 2020-09-29 16:26
 **/
public class MaximumHeap {

    /**
     * 上浮
     * @param array
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉
     * @param array 待调整的堆
     * @param parentIndex 要下沉的节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int childIndex = parentIndex * 2 + 1;
        int temp = array[parentIndex];
        while (childIndex < length) {
            //如果有右孩子，且右孩子大于左孩子，则定位到右孩子
            //最大堆的定义是父节点大于等于左右孩子
            //所以对于一次调整，父、左、右中的最大的，将成为新的父节点
            if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1]) {
                childIndex++;
            }
            if (temp > array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array,i, array.length);
        }
    }

    public static void main(String[] args) {
        System.out.println();
        int[] array = new int[]{10,9,7,6,8,4,5,2,3,12};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

}
