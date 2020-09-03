package com.waibizi.solution_2;

/**
 * @Author 歪鼻子
 * @Date 2020/9/2 13:32
 * @Description: 后续遍历是：左、右、根。也就是如果中间有分割线，如果这个分割线的右，有小于根的，肯定不是二叉搜索
 * @Version 1.0
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return operation(postorder,0,postorder.length-1);
    }
    private boolean operation(int[] postorder,Integer left,Integer right){
        if (left >= right) return true;
        int mid = left;
        int root = postorder[right];
        while (postorder[mid] < postorder[right]){
            mid++;
        }
        int flag = mid;

        while (flag < right){
            if (postorder[flag++] < postorder[right]){
                return false;
            }
        }
        return operation(postorder,left,mid - 1) && operation(postorder,mid,right-1);
    }
}
