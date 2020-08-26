package com.waibizi.tree;




/**
 * @Author 歪鼻子
 * @Date 2020/8/26 22:52
 * @Description: 其实高度也是这样算的
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        /* 如果可以执行下面的代码，就代表当前进来的节点是有效 */
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
