package com.waibizi;

import com.waibizi.双向链表.LinkedList;

/**
 * @Author 歪鼻子
 * @Date 2020/7/31 22:07
 * @Description:
 * @Version 1.0
 */
public class 双向链表测试 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList.toString());
        for (int i = 0; i < 10; i++){
            linkedList.remove(0);
            System.out.println(linkedList.toString());
        }
    }
}
