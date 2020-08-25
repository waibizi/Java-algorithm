package com.waibizi;

import com.waibizi.双向链表.双向循环链表.DoubleCircleLinkedList;

/**
 * @Author 歪鼻子
 * @Date 2020/7/31 23:52
 * @Description:
 * @Version 1.0
 */
public class 双向循环队列测试 {
    public static void main(String[] args) {
        DoubleCircleLinkedList<Integer> linkedList = new DoubleCircleLinkedList<>();
        for (int i = 0; i < 10; i++){
            linkedList.add(i);
            System.out.println(linkedList.toString());
        }
        System.out.println(linkedList.remove(4));
        linkedList.add(4,4);
        for (int i = 0; i < 10; i++){
            linkedList.remove(0);
            System.out.println(linkedList.toString());
        }
    }
}
