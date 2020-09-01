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
//        for (int i =0; i < 10; i++){
//            tree.add(i);
//        }
//        System.out.println(tree.isComplete());
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(9);

        BinaryTrees.println(tree);
        System.out.println(tree.isComplete());
        tree.remove(5);
        BinaryTrees.println(tree);
        tree.remove(8);
        BinaryTrees.println(tree);
    }
}
