package com.waibizi.队列;

import com.waibizi.list.LinkedList;
import com.waibizi.list.List;

/**
 * @Author 歪鼻子
 * @Date 2020/8/2 17:43
 * @Description:
 * @Version 1.0
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();
    private int size(){
        return list.size();
    }
    public void clear(){
        list.clear();
    }
    public void addLast(E element){
        list.add(element);
    }
    public E removeFirst(){
        return list.remove(0);
    }
    public E peekFirst(){
        return list.get(0);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public String toString() {
        return list.toString();
    }
}
