package com.waibizi.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author 歪鼻子
 * @Date 2020/8/26 23:01
 * @Description:
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SolutionStack {

    public TreeNode mirrorTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return null;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left!=null) stack.push(node.left);
            if (node.right!=null) stack.push(node.right);
            TreeNode swap = node.left;
            node.left = node.right;
            node.right = swap;
        }
        return root;
    }
}
