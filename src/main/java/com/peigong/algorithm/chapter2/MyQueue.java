package com.peigong.algorithm.chapter2;

/**
 * @author: lilei
 * @create: 2020-09-14 15:48
 **/
public class MyQueue<T> {

    private Object[] items;

    private int front;
    private int rear;

    private int eleCount;

    public MyQueue(int capacity) {
        this.items = new Object[capacity];
    }

    public void enQueue(T t) {
        if(rearPos() == front) throw new RuntimeException("队列已满");
        items[rear] = t;
        rear = rearPos();
        eleCount++;
    }

    public T deQueue() {
        if(rear == front) throw new RuntimeException("队列为空");
        T deEle = (T)items[front];
        front = frontPos();
        eleCount--;
        return deEle;
    }

    public void print() {
        for (int i = front; i != rear; i = (i + 1) % items.length) {
            System.out.println(items[i]);
        }
    }

    public int eleCount() {
        return eleCount;
    }

    /**
     * 计算循环队列下一个队尾的索引
     * @return
     */
    private int rearPos() {
        return (rear + 1) % items.length;
    }

    /**
     * 计算循环队列下一个队首的索引
     * @return
     */
    private int frontPos() {
        return (front + 1) % items.length;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(10);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.print();
        System.out.println("deQueue:" + queue.deQueue());
        queue.enQueue(5);
        queue.print();
        System.out.println("eleCount:" + queue.eleCount());
    }

}
