package com.waibizi.solution_1;

import java.util.Stack;

/**
 * @Author 歪鼻子
 * @Date 2020/7/29 17:58
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int flag = 0;
        for (int num : pushed){
            stack.push(num);
            /* 如果栈不为空，并且已经入栈的数据顶部与pop相同，即代表可以pop出来一个，然后游标递增。（这个条件得益于栈的元素不会重复的） */
            while (!stack.isEmpty()&&stack.peek() == popped[flag]){
                stack.pop();
                flag++;
            }
        }
        /* 如果全部被弹出来了，直接拿这个判断即可 */
        return stack.isEmpty();
    }
}
