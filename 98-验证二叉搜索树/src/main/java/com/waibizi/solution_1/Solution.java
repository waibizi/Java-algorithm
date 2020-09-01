package com.waibizi.solution_1;



/**
 * @Author 歪鼻子
 * @Date 2020/9/1 20:22
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

    long val = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val<=val   ){
            return false;
        }
        val = root.val;
        return isValidBST(root.right);
    }

}
