package com.waibizi;

import com.waibizi.print.BinaryTrees;
import com.waibizi.tree.BinarySearchTree;


/**
 * @Author 歪鼻子
 * @Date 2020/8/25 16:28
 * @Description:
 * @Version 1.0
 */
public class 二叉搜索树测试 {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i =0; i < 10; i++){
            tree.add(i);
        }

        BinaryTrees.println(tree);
    }
}
