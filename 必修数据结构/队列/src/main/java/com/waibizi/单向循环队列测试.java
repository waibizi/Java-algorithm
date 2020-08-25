package com.waibizi;

import com.waibizi.循环队列.CircleQueue;

/**
 * @Author 歪鼻子
 * @Date 2020/8/4 16:47
 * @Description:
 * @Version 1.0
 */
public class 单向循环队列测试 {
    public static void main(String[] args) {
        CircleQueue<Integer> circleQueue = new CircleQueue<>();
        for (int i = 0; i < 10; i++){
            circleQueue.add(i);
        }
        /* capacity = 10size = 10 front= 0, [0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 ] */
        System.out.println(circleQueue.toString());
        /* 0 */
        System.out.println(circleQueue.remove());
        /* capacity = 10size = 9 front= 1, [null , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 ] */
        System.out.println(circleQueue.toString());
        circleQueue.add(100);
        /* capacity = 10size = 10 front= 1, [100 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 ] */
        System.out.println(circleQueue.toString());
    }
}
