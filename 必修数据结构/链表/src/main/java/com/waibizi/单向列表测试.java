package com.waibizi;

import com.waibizi.单向链表.SingleLinkedList;

/**
 * @Author 歪鼻子
 * @Date 2020/7/31 21:57
 * @Description:
 * @Version 1.0
 */
public class 单向列表测试 {
    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        /* 0,1,2,3,4,5,6,7,8,9 */
        for (int i = 0; i < 10 ; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList.toString());
        for (int i = 0; i < 10; i++){
            linkedList.remove(0);
            System.out.println(linkedList.toString());
        }
    }
}
