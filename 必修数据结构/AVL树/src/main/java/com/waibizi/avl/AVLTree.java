package com.waibizi.avl;

import com.waibizi.avl.tree.BinarySearchTree;

/**
 * @Author 歪鼻子
 * @Date 2020/9/2 12:54
 * @Description:
 * @Version 1.0
 */
public class AVLTree {
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E> parent){
            this.element = element;
            this.parent = parent;
        }
        /* 判断该结点是不是叶子 */
        public boolean isLeaf() {
            return left == null && right == null;
        }
        /* 判断是否有两个孩子 */
        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }

}
