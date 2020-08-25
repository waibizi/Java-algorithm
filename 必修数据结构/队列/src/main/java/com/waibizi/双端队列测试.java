package com.waibizi;

import com.waibizi.双端队列.Deque;

/**
 * @Author 歪鼻子
 * @Date 2020/8/2 16:48
 * @Description:
 * @Version 1.0
 */
public class 双端队列测试 {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i++){
            deque.addLast(i);
        }
        System.out.println(deque.toString());
    }
}
