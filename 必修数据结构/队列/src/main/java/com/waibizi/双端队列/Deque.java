package com.waibizi.双端队列;

import com.waibizi.list.LinkedList;
import com.waibizi.list.List;

/**
 * @Author 歪鼻子
 * @Date 2020/7/31 16:29
 * @Description:
 * @Version 1.0
 */
public class Deque<E> {
    private List<E> list = new LinkedList<>();
    private int size(){
        return list.size();
    }
    public void clear(){
        list.clear();
    }
    public void addFirst(E element){
        list.add(0,element);
    }
    public void addLast(E element){
        list.add(element);
    }
    public E removeFirst(){
       return list.remove(0);
    }
    public E removeLast(){
        return list.remove(list.size()-1);
    }
    public E peekFirst(){
        return list.get(0);
    }
    public E peekLast(){
        return list.get(list.size()-1);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public String toString() {
        return list.toString();
    }
}
