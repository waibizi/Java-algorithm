package com.waibizi;

import java.util.Stack;

/**
 * @Author 歪鼻子
 * @Date 2020/7/29 17:34
 * @Description:
 * @Version 1.0
 */
public class CQueue {
    private Stack<Integer> instack;
    private Stack<Integer> outstack;
    public CQueue() {
        instack = new Stack<>();
        outstack = new Stack<>();
    }

    public void appendTail(int value) {
        instack.push(value);
    }

    public int deleteHead() {
        if (outstack.isEmpty()){
            while (!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }

        if (outstack.isEmpty()){
            return -1;
        }
        return outstack.pop();
    }
}
