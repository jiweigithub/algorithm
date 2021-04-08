package com.shangguigu.datastructures.tree.sort;

/**
 * 二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            Node node = new Node(i);
            binarySortTree.add(node);
        }
        System.out.println("删除前");
        binarySortTree.infixOrder();
        binarySortTree.delete(2);
        binarySortTree.delete(5);
        binarySortTree.delete(9);
        binarySortTree.delete(12);
        binarySortTree.delete(7);
        binarySortTree.delete(3);
        binarySortTree.delete(10);
        binarySortTree.delete(1);
        System.out.println("删除后");
        binarySortTree.infixOrder();
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

    public void delete(int value) {
        if (this.root == null) {
            return;
        }
        Node targetNode = this.root.find(value);
        if (targetNode == null) {
            return;
        }
        //如果根节点是一个叶子节点，说明只有一个节点，且目标节点就是根节点
        if (root.isLeaf()) {
            root = null;
            return;
        }
        //找到待删除节点的父节点
        Node parent = root.findParent(value);
        //如果targetNode是叶子节点
        if (targetNode.isLeaf()) {
            if (parent.right != null && targetNode.value == parent.right.value) {
                parent.right = null;
            } else if (parent.left != null && targetNode.value == parent.left.value) {
                parent.left = null;
            }
        } else if (targetNode.hasOneLeft()) {
            if (parent == null) {
                root = targetNode.left;
            } else if (parent.right != null && targetNode.value == parent.right.value) {
                parent.right = targetNode.left;
            } else if (parent.left != null && targetNode.value == parent.left.value) {
                parent.left = targetNode.left;
            }
        } else if (targetNode.hasOneRight()) {
            if (parent == null) {
                root = targetNode.right;
            } else if (parent.right != null && targetNode.value == parent.right.value) {
                parent.right = targetNode.right;
            } else if (parent.left != null && targetNode.value == parent.left.value) {
                parent.left = targetNode.right;
            }
        } else {
            int min = delRightTreeMin(targetNode.right);
            targetNode.value = min;
        }
    }

    /**
     * 删除以node为根节点的二叉排序树的最小节点，并返回该节点的值
     *
     * @param node 以node为根节点的二叉排序树
     * @return 返回以node为根节点的二叉排序树的最小节点值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        //此时target就指向了最小节点
        delete(target.value);
        return target.value;
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
     * 查找待删除节点
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
        } else {
            if (value < this.value && this.left != null) {
                return this.left.findParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.findParent(value);
            } else {
                return null;
            }
        }
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

