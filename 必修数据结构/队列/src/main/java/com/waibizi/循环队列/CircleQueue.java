package com.waibizi.循环队列;

import java.util.Arrays;

/**
 * @Author 歪鼻子
 * @Date 2020/8/2 17:45
 * @Description:
 * @Version 1.0
 */
public class CircleQueue<E> {
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }
    public int size(){
        return size;
    }
    public void add(E element){
        ensureCapacity(size+1);
        elements[index(size)] = element;
        size++;
    }
    public E remove(){
        E rmElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return rmElement;
    }
    public E peek(){
        return elements[front];
    }
    /**
     * 这个函数的作用可以理解为，如果我需要当前位置的下index位置
     * 可是我不知道这个位置是不是合法，这个可以帮我计算一个front+index得到距离
     * 这个还是合法的情况
     * @param index
     * @return
     */
    private int index(int index){
        index += front;
        /* 这个计算方式特别牛逼，如果需要插入的索引位置大于长度了，
        * 用这个位置减去长度就是头开始的位置开始计数。如果长度没有
        * 超，也就是原先的索引位置+1即可，而front+size正好符合这个条件
        */
        return index - (index >= elements.length ? elements.length : 0);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity = ").append(elements.length)
                .append( "size = ").append(size).append(" front= ").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++){
            if (i != 0){
                string.append(" , ");
            }
            string.append(elements[i]);
        }
        string.append(" ]");
        return string.toString();
    }

    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        /* 扩容1.5倍 */
        int newCapacity = oldCapacity + (oldCapacity>>1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++){
            /* 这里也应该注意一下 */
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
    }
}
