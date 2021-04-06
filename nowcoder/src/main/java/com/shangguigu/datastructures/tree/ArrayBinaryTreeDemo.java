package com.shangguigu.datastructures.tree;

/**
 * 顺序存储二叉树
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.postOrder();
    }
}

/**
 * 实现顺序存储二叉树
 */
class ArrayBinaryTree {
    /**
     * 存储数据
     */
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 顺序存储二叉树的前序遍历
     *
     * @param index 表示数组的下标
     */
    public void preOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历！");
            return;
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历！");
            return;
        }
        //向左中序遍历
        if (index * 2 + 1 < arr.length) {
            infixOrder(index * 2 + 1);
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向右中序遍历
        if (index * 2 + 2 < arr.length) {
            infixOrder(2 * index + 2);
        }
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历！");
            return;
        }
        //向左后序遍历
        if (index * 2 + 1 < arr.length) {
            postOrder(index * 2 + 1);
        }
        //向右后序遍历
        if (index * 2 + 2 < arr.length) {
            postOrder(2 * index + 2);
        }
        //输出当前这个元素
        System.out.println(arr[index]);
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }
}
