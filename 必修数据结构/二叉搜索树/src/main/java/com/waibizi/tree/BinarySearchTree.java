package com.waibizi.tree;

import com.waibizi.print.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 歪鼻子
 * @Date 2020/8/5 14:46
 * @Description: 二叉搜索树
 * @Version 1.0
 */
@SuppressWarnings("ALL")
public class BinarySearchTree<E> implements BinaryTreeInfo {
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element,Node<E> parent){
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

    private int size;
    private Node<E> root;
    private Comparator<E> comparator;
    public BinarySearchTree(){
        this(null);
    }
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void clear(){
        root = null;
        size = 0;
    }

    /**
     * 往二叉树搜索树添加元素
     * @param element
     */
    public void add(E element){
        elementNotNullCheck(element);
        /* 添加当前树的第一个节点 */
        if (root == null){
            root = new Node<>(element,null);
            size++;
            return;
        }
        /* 首先找到父节点 */
        Node<E> parent = root;
        Node<E> node = root;

        int flag = 0;
        do{
            flag = compare(element,node.element);
            parent = node;
            if (flag < 0){
                node = node.left;
            }else if (flag > 0){
                node = node.right;
            }else {
                /* 因为二叉搜索树不允许存在两个节点都是同一个值的情况 */
                node.element = element;
                return;
            }
        }while (node != null);
        Node<E> newNode = new Node<>(element,parent);
        if (flag > 0){
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        size++;
    }

    /**
     * 前序遍历
     * @param operation
     */
    public void preorderTraversal(Operation<E> operation){
        if (operation != null)
            preorderTraversal(root,operation);
    }

    public void preorderTraversal(Node<E> node,Operation<E> operation){
        if (node == null) return;
        operation.execute(node.element);
        preorderTraversal(node.left,operation);
        preorderTraversal(node.right,operation);
    }



    /* 中序遍历 */
    public void inorderTraversal(Operation<E> operation) {
        if (operation != null)
            inorderTraversal(root,operation);
    }

    public void inorderTraversal(Node<E> node,Operation<E> operation) {
        if (node == null) return;
        inorderTraversal(node.left,operation);
        operation.execute(node.element);
        inorderTraversal(node.right,operation);
    }

    /**
     * 后续遍历
     * @param operation
     */
    public void postoderTraversal(Operation<E> operation) {
        if (operation != null) postoderTraversal(root,operation);
    }

    public void postoderTraversal(Node<E> node,Operation<E> operation) {
        if (operation == null) return;
        postoderTraversal(node.left,operation);
        postoderTraversal(node.right,operation);
        operation.execute(node.element);
    }

    /**
     * 层序遍历
     * @param operation
     */
    public void levelOrder(Operation<E> operation){
        if (root == null || operation == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (operation.execute(node.element)) return;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    /**
     * 判断是不是完全二叉树，如果是返回true，如果不是返回false
     */
    public boolean isComplete() {
        if (root != null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        /* 剩下都是叶子的标志 */
        boolean isLeaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            /* 如果剩下的要求都是叶子，但是当前的节点并不是叶子节点，所以直接返回false就可以了 */
            if (isLeaf && !node.isLeaf()){
                return false;
            }
            if (node.left!=null)
                queue.offer(node.left);
            else if (node.right != null)
                /* 能走到这一步，说明node.left == null 了，但是node.right != null ,已经说明不是完全二叉了 */
                return false;
            /* 这一步的判断跟上面的不一样，理清逻辑就好理解了 */
            if (node.right != null)
                queue.offer(node.right);
            else
                /* 如果node.left!=null但是node.right==null了，说明接下来都是叶子才符合完全二叉 */
                isLeaf = true;
        }
        return true;
    }

    /**
     * 操作接口
     * @param <E>
     */
    public static interface Operation<E>{
        boolean execute(E element);
    }

    /**
     * 根据元素的值，获取节点（因为二叉搜索树不能存在两个相同的节点）z
     * @param element
     * @return
     */
    private Node<E> node(E element){
        Node<E> node = root;
        while (node != null){
            int flag = compare(element,node.element);
            if (flag == 0) return node;
            if (flag < 0) node = node.left; else node = node.right;
        }
        return null;
    }


    /**
     * 如果e1等于e2返回0，如果e1大于e2返回值大于0，如果e1小于e2返回值小于0
     * @param e1
     * @param e2
     * @return
     */
    public int compare(E e1,E e2){
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        /* 如果没有指定比较的值，就强制性比较 */
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null){
            throw new IllegalArgumentException("不可以传入空节点");
        }
    }
}
