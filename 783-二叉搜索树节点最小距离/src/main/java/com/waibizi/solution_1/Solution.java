package com.waibizi.solution_1;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 歪鼻子
 * @Date 2020/9/1 2:01
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
    Integer res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        return operation(root);
    }
    public int operation(TreeNode node){
        if (node == null) return 0;
        operation(node.left);
        if (pre!=null)
            res = Math.min(res,node.val-pre.val);
        pre = node;
        operation(node.right);
        return res;
    }
    /**
     * 错误解法：临时变量，不是全局变量，导致值的变化不见了
     class Solution {
     TreeNode pre = null;
     public int minDiffInBST(TreeNode root) {
     if (root == null) return 0;
     return operation(root,Integer.MAX_VALUE);
     }
     public int operation(TreeNode node,Integer res){
     if (node == null) return 0;
     operation(node.left,res);
     if (pre!=null)
     res = Math.min(res,node.val-pre.val);
     pre = node;
     operation(node.right,res);
     return res;
     }
     }     *
     */
}

