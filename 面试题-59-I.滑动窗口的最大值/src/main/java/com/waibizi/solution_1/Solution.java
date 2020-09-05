package com.waibizi.solution_1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 歪鼻子
 * @Date 2020/9/5 23:38
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return nums;
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0,j = 1 - k; i < nums.length; i++,j++){
            if (j > 0 && deque.peekFirst() == nums[j-1]){
                deque.removeFirst();
            }
            /* 对不起，我的队列并不想存储比我当前遍历到的数组小的元素，所以你走吧 */
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (j >= 0){
                res[j] = deque.peekFirst();
            }
        }
        return res;
    }
}
