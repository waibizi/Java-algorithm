package com.waibizi.tree;

/**
 * @Author 歪鼻子
 * @Date 2020/8/26 23:21
 * @Description:
 * @Version 1.0
 */
public class SolutionDIGUI {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode swap = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(swap);
        return root;
    }
}
