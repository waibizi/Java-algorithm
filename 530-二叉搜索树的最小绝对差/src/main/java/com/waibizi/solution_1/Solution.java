package com.waibizi.solution_1;

/**
 * @Author 歪鼻子
 * @Date 2020/9/1 20:07
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
    TreeNode pre = null;
    Integer min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        return operation(root);
    }
    public Integer operation(TreeNode node){
        if (node == null) return 0;
        operation(node.left);
        if (pre != null) min = Math.min(min,Math.abs(node.val-pre.val));
        pre = node;
        operation(node.right);
        return min;
    }
}
