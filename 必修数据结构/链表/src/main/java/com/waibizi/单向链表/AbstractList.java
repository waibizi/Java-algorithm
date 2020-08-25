package com.waibizi.单向链表;

/**
 * @Author 歪鼻子
 * @Date 2020/7/31 16:34
 * @Description:
 * @Version 1.0
 */
public abstract class AbstractList<E> implements List<E> {
    /**
     * 链表元素的链表
     */
    protected int size;
    /**
     * 返回元素的数量
     */
    public int size(){
        return size;
    }
    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * 判断是否包含某个元素
     */
    public boolean contains(E element){
        return indexOf(element) == ELEMENT_NOT_FOUND;
    }
    /**
     * 往尾部添加元素
     */
    public void add(E element){
        add(size,element);
    }
    /**
     * 抛出异常
     */
    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+", Size"+size);
    }
    /**
     * 需要检索数组的时候都需要检查下标先
     * @param index
     */
    protected void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }
    /**
     * 链表不能跨空节点添加数据
     * @param index
     */
    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }
}
