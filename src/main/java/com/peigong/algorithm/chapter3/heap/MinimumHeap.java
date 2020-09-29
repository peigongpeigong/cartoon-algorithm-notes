package com.peigong.algorithm.chapter3.heap;

import java.util.Arrays;

/**
 * 最小堆的自我调整
 * @author: lilei
 * @create: 2020-09-29 15:46
 **/
public class MinimumHeap {

    /**
     * 上浮
     * @param array
     */
    public static void upAdjust(int[] array) {
        //最后的孩子节点的index
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - ((childIndex - 1) % 2 + 1)) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - ((childIndex - 1) % 2 + 1)) / 2;
        }
        array[parentIndex] = temp;
    }

    /**
     * 下沉
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        //首先得到左孩子的索引
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果右孩子的索引小于堆元素的数量，那么右孩子一定存在
            //如果左孩子大于右孩子，那么将孩子节点定位到右孩子
            //因为是最小堆，父节点一定小于或等于左右孩子节点
            //所以找出左右孩子中最小的，与父节点对比即可
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //如果父节点小于最小孩子节点，那么符合最小堆约定
            if (temp < array[childIndex]) {
                break;
            }
            //父节点下沉，相当于孩子节点中小的那个上浮
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

}
