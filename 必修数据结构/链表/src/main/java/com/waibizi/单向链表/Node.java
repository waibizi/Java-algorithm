package com.waibizi.单向链表;

/**
 * @Author 歪鼻子
 * @Date 2020/7/11 17:35
 * @Description: 默认采用双向链表
 * @Version 1.0
 */
public class Node<E> {

    public E element;
    public Node next;
    /**
     * 构造一个节点的时候，就已经把上一个节点的位置传入进来完成构造新节点
     * @param element
     * @param next
     */
    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (next != null){
            sb.append(next.element);
        }else {
            sb.append("null");
        }
        sb.append("---").append(element).append("---");
        return sb.toString();
    }
}
