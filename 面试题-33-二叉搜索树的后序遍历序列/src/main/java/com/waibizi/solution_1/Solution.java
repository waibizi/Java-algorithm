package com.waibizi.solution_1;

import java.util.Stack;

/**
 * @Author 歪鼻子
 * @Date 2020/9/2 13:15
 * @Description: 后续遍历是：左、右、根。但是我们的比较大小是左 < 右 > 根 ,可以将数组翻转一下，变成了翻转二叉树的先序遍历,
 *              遍历顺序就是：根、右、左。如果说入栈的根小于左，我们直接false
 * @Version 1.0
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int pre = Integer.MAX_VALUE;
        for (int index = postorder.length-1; index >= 0; index--){
            if (postorder[index] > pre){
                return false;
            }
            while (!stack.isEmpty() && postorder[index] < stack.peek()){
                pre = stack.pop();
            }
            stack.push(postorder[index]);
        }
        return true;
    }
}
