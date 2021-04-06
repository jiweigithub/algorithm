package com.shangguigu.datastructures.tree.threaded;

/**
 * 线索化二叉树
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(3, "吴用");
        HeroNode node3 = new HeroNode(6, "卢俊义");
        HeroNode node4 = new HeroNode(8, "林冲");
        HeroNode node5 = new HeroNode(10, "关胜");
        HeroNode node6 = new HeroNode(14, "花荣");

        //二叉树，后面要递归创建，现在简单处理
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();
        binaryTree.setRoot(root);
        binaryTree.threadedNodes(root);
        binaryTree.threadInfixOrder();
    }
}

/**
 * 定义二叉树
 */
class ThreadedBinaryTree {
    /**
     * 根节点属性
     */
    private HeroNode root;

    /**
     * 为了实现线索化，需要定义当前节点的前驱节点的指针
     * 在递归进行线索化时，pre总是保留前一个节点
     */
    private HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 中序线索化二叉树
     *
     * @param node 就是当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }

        //1.线索化左子树
        threadedNodes(node.getLeft());
        //2.线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型为指向前驱节点
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向后继节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        //3.线索化右子树
        threadedNodes(node.getRight());
    }

    /**
     * 遍历中序线索化化二叉树
     */
    public void threadInfixOrder() {
        //定义一个变量，存储当前遍历的节点,从root开始
        HeroNode node = root;
        while (node != null) {
            //循环找到leftType == 1的节点（被线索化的节点）
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前被线索化的节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRight();
        }
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

    /**
     * 0--指向左子树 1--指向前驱节点
     */
    private int leftType;

    /**
     * 0--指向右子树 1--指向后继节点
     */
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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