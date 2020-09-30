package com.peigong.algorithm.chapter3.heap;

/**
 * @author: lilei
 * @create: 2020-09-29 18:37
 **/
public class PriorityQueue<E extends Comparable<E>> {

    private int size;
    private Object[] items;

    public PriorityQueue(int capacity) {
        this.items = new Object[capacity];
    }

    public void enQueue(E e) {
        if (size == items.length) {
            resize();
        }
        items[size++] = e;
        upAdjust();
    }

    public E deQueue() {
        if (size <= 0) {
            throw new RuntimeException("empty queue");
        }
        E head = (E) items[0];
        items[0] = items[--size];
        downAdjust();
        return head;
    }


    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        E temp = (E)items[childIndex];
        while (childIndex > 0 && temp.compareTo((E) items[parentIndex]) > 0) {
            items[childIndex] = items[parentIndex];
            childIndex = parentIndex;
            //parentIndex = (childIndex - 1) / 2;
            parentIndex = parentIndex / 2;
        }
        items[childIndex] = temp;
    }

    private void downAdjust() {
        int parentIndex = 0;
        E temp = (E) items[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            if (childIndex + 1 < size && ((E) items[childIndex]).compareTo(((E) items[childIndex + 1])) < 0) {
                childIndex++;
            }
            if (((E) items[childIndex]).compareTo(temp) < 0) {
                break;
            }
            items[parentIndex] = items[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        items[parentIndex] = temp;
    }

    private void resize() {
        Object[] newArr = new Object[items.length << 1];
        System.arraycopy(items, 0, newArr, 0, items.length);
        items = newArr;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5);
        queue.enQueue(3);
        queue.enQueue(1);
        queue.enQueue(5);
        queue.enQueue(8);
        queue.enQueue(15);
        queue.enQueue(6);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
