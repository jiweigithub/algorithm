package com.shangguigu.datastructures.tree.sort;

/**
 * 二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            Node node = new Node(i);
            binarySortTree.add(node);
        }
        binarySortTree.infixOrder();
        Node node = binarySortTree.find(3);
        System.out.println("查找到的节点：" + node);
    }
}

class BinarySortTree {

    /**
     * 根节点
     */
    Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }

    public Node find(int value) {
        if (root != null) {
            return root.find(value);
        } else {
            return null;
        }
    }

}

class Node {
    /**
     * 值域
     */
    int value;
    /**
     * 左子节点
     */
    Node left;
    /**
     * 右子节点
     */
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left != null) {
                this.left.add(node);
            } else {
                this.left = node;
            }
        }
        if (node.value >= this.value) {
            if (this.right != null) {
                this.right.add(node);
            } else {
                this.right = node;
            }
        }
    }

    public void delete(int value) {

    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasOneLeft() {
        return this.left != null && this.right == null;
    }

    public boolean hasOneRight() {
        return this.left == null && this.right != null;
    }

    /**
     * 查找节点
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left != null) {
                return this.left.find(value);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.find(value);
            } else {
                return null;
            }
        }
    }

    /**
     * 查找节点的父节点
     *
     * @param value
     * @return
     */
    public Node findParent(int value) {
        boolean leftEqual = this.left != null && this.left.value == value;
        boolean rightEqual = this.right != null && this.right.value == value;
        if (leftEqual || rightEqual) {
            return this;
        }
        if (this.left != null && value < this.left.value) {
            this.left.findParent(value);
        }
        return null;
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}

