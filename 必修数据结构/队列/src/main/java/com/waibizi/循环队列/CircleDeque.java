package com.waibizi.循环队列;

/**
 * @Author 歪鼻子
 * @Date 2020/8/4 16:51
 * @Description:
 * @Version 1.0
 */
public class CircleDeque<E> {
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 返回循环双端队列的实际大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 判断循环双端队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 从尾部入队
     * @param element
     */
    public void addLast(E element) {
        elements[index(size)]  = element;
        size++;
    }

    /**
     * 从头部入队
     * @param element
     */
    public void addFirst(E element) {
        elements[index(-1)] = element;
        size++;
    }

    /**
     * 从尾部出队
     * @return
     */
    public E removeLast(){
        int rearIndex = index(size-1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }

    /**
     * 从头部出队
     * @return
     */
    public E removeFirst() {
        int frontIndex = index(size-1);
        E front = elements[frontIndex];
        elements[frontIndex] = null;
        size--;
        return front;
    }
    /**
     * 清除所有的元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }
    private int index(int index) {
        index += front;
        /* 尽量避免使用 * / % 运算，以及浮点数的运算，这类运算效率都比较低下 */
        return index - (index >= elements.length ? elements.length : 0);
    }

    /**
     * 扩容为原来的1.5倍
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        /* 新的容量扩容为原来的1,5倍 */
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i< elements.length; i++){
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
    }
}
