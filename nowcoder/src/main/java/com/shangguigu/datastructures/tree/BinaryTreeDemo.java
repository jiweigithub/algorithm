package com.shangguigu.datastructures.tree;

/**
 * 二叉树演示
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(node1);

//        System.out.println("二叉树前序遍历：");
//        binaryTree.preOrder();
//        System.out.println("二叉树中序遍历：");
//        binaryTree.infixOrder();
//        System.out.println("二叉树后序遍历：");
//        binaryTree.infixSearch(3);
        System.out.println("删除前，前序遍历~~");
        binaryTree.preOrder();
        binaryTree.remove(3);
        System.out.println("删除后，前序遍历~~");
        binaryTree.preOrder();
    }
}

/**
 * 定义二叉树
 */
class BinaryTree {
    /**
     * 根节点属性
     */
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void remove(int no) {
        if (this.root == null) {
            System.out.println("二叉树为空，无法删除");
            return;
        }
        if (this.root.getNo() == no) {
            this.setRoot(null);
        } else {
            this.root.remove(no);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 前序查找
     *
     * @param no
     */
    public void preSearch(int no) {
        if (this.root != null) {
            HeroNode heroNode = this.root.preSearch(no);
            if (heroNode != null) {
                System.out.println(heroNode);
            } else {
                System.out.printf("编号%d的英雄未找到\n", no);
            }
        } else {
            System.out.println("二叉树为空，无法查找");
        }
    }

    /**
     * 中序查找
     *
     * @param no
     */
    public void infixSearch(int no) {
        if (this.root != null) {
            HeroNode heroNode = this.root.infixSearch(no);
            if (heroNode != null) {
                System.out.println(heroNode);
            } else {
                System.out.printf("编号%d的英雄未找到\n", no);
            }
        } else {
            System.out.println("二叉树为空，无法查找");
        }
    }

    /**
     * 后序查找
     *
     * @param no
     */
    public void postSearch(int no) {
        if (this.root != null) {
            HeroNode heroNode = this.root.postSearch(no);
            if (heroNode != null) {
                System.out.println(heroNode);
            } else {
                System.out.printf("编号%d的英雄未找到\n", no);
            }
        } else {
            System.out.println("二叉树为空，无法查找");
        }
    }
}

/**
 * 定义英雄节点
 */
class HeroNode {

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    private HeroNode parent;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode getParent() {
        return parent;
    }

    public void setParent(HeroNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        //先输出当前节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出当前节点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序查找
     *
     * @return
     */
    public HeroNode preSearch(int no) {
        System.out.println("前序查找");
        HeroNode result = null;
        if (this.getNo() == no) {
            result = this;
        }
        if (result != null) {
            return result;
        }
        if (this.left != null) {
            result = this.left.preSearch(no);
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.preSearch(no);
        }
        return result;
    }

    /**
     * 中序查找
     *
     * @param no
     */
    public HeroNode infixSearch(int no) {
        HeroNode result = null;
        if (this.left != null) {
            result = this.left.infixSearch(no);
        }
        if (result != null) {
            return result;
        }
        System.out.println("中序查找");
        if (this.getNo() == no) {
            result = this;
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.infixSearch(no);
        }
        return result;
    }

    /**
     * 后序查找
     *
     * @param no
     */
    public HeroNode postSearch(int no) {
        HeroNode result = null;
        if (this.left != null) {
            result = this.left.postSearch(no);
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.postSearch(no);
        }
        if (result != null) {
            return result;
        }
        System.out.println("后序查找");
        if (this.getNo() == no) {
            result = this;
        }
        return result;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasLeft() {
        return this.left != null && this.right == null;
    }

    public boolean hasRight() {
        return this.left == null && this.right != null;
    }

    public boolean isFull() {
        return this.left != null && this.right != null;
    }

    public void remove(int no) {
        if (this.left != null && this.left.no == no) {
            if (this.left.isLeaf()) {
                this.left = null;
            } else {
                if (this.left.hasLeft() && !this.left.hasRight()) {
                    HeroNode newLeft = this.left.getLeft();
                    this.setLeft(newLeft);
                } else if (!this.left.hasLeft() && this.left.hasRight()) {
                    HeroNode newLeft = this.left.getRight();
                    this.setLeft(newLeft);
                } else if (this.isFull()) {
                    HeroNode newLeft = this.left.getLeft();
                    HeroNode right = this.left.getRight();
                    newLeft.setRight(right);
                    this.setLeft(newLeft);
                }
            }
            return;
        }
        if (this.right != null && this.right.no == no) {
            if (this.right.isLeaf()) {
                this.right = null;
            } else {
                if (this.right.hasLeft() && !this.right.hasRight()) {
                    HeroNode newRight = this.right.getLeft();
                    this.setRight(newRight);
                } else if (!this.right.hasLeft() && this.right.hasRight()) {
                    HeroNode newRight = this.left.getRight();
                    this.setRight(newRight);
                } else if (this.isFull()) {
                    HeroNode newRight = this.right.getLeft();
                    HeroNode right = this.right.getRight();
                    newRight.setRight(right);
                    this.setRight(newRight);
                }
            }
            return;
        }
        if (this.left != null) {
            this.left.remove(no);
        }
        if (this.right != null) {
            this.right.remove(no);
        }
    }
}

