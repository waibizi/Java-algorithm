package com.waibizi.solution_1;



/**
 * @Author 歪鼻子
 * @Date 2020/9/3 3:33
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root== p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
