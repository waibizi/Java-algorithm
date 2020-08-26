package com.waibizi.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 歪鼻子
 * @Date 2020/8/26 23:29
 * @Description: 这个
 * @Version 1.0
 */
public class SolutionQueue {
    public TreeNode mirrorTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return null;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode swap = node.left;
            node.left = node.right;
            node.right = swap;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
