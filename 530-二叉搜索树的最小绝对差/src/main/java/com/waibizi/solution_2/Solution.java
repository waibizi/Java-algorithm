package com.waibizi.solution_2;

/**
 * @Author 歪鼻子
 * @Date 2020/9/1 20:15
 * @Description:
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    int pre = -1;
    int min  = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
       return operation(root);
    }
    private int operation(TreeNode node){
        if (node == null) return 0;
        operation(node.left);
        if (pre == -1){
            pre = node.val;
        }else {
            min = Math.min(min,node.val-pre);
        }
        pre = node.val;
        operation(node.right);
        return min;
    }
}
