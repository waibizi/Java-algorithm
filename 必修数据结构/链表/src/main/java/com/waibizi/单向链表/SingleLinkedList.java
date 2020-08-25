package com.waibizi.单向链表;

/**
 * @Author 歪鼻子
 * @Date 2020/7/31 16:47
 * @Description:
 * @Version 1.0
 */
public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    /* 这种清除方式涉及到JVM的回收机制 */
    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 这里是添加，往index位置添加元素，也就是会把原来的元素挤掉
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        if (index == 0){
            first = new Node<>(element,first);
        }else {
            Node<E> pre = node(index - 1);
            pre.next = new Node(element,pre.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0){
            first = first.next;
        }else{
            Node<E> pre = node(index - 1);
            node = pre.next;
            pre.next = pre.next.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){
            Node<E> node = first;
            for (int i = 0; i < size; i++){
                if (node.element == null){
                    return i;
                }
                node = node.next;
            }
        }else {
            Node<E> node = first;
            for (int i = 0; i < size; i++){
                if (node.element == element){
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    public Node<E> node(int index){
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string= new StringBuilder();
        string.append("size = ").append(size).append(",element = [");
        Node<E> node = first;
        for (int i = 0; i < size; i++){
            if (i != 0){
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
