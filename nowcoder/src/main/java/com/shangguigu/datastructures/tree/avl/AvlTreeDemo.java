package com.shangguigu.datastructures.tree.avl;

/**
 * 平衡二叉树
 */
public class AvlTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        //创建AvlTree
        AvlTree avlTree = new AvlTree();
        //添加节点
        for (int value : arr) {
            avlTree.add(new Node(value));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("在平衡处理后~~");
        System.out.println("树的高度：" + avlTree.root.height());
        System.out.println("左子树的高度：" + avlTree.root.leftHeight());
        System.out.println("右子树的高度：" + avlTree.root.rightHeight());
        System.out.println("根节点为：" + avlTree.root);
        System.out.println("根节点左子节点为：" + avlTree.root.left);
        System.out.println("根节点右子节点为：" + avlTree.root.right);
        avlTree.delete(6);
        System.out.println("删除6节点后树的高度：" + avlTree.root.height());
        System.out.println("删除6节点后左子树的高度：" + avlTree.root.leftHeight());
        System.out.println("删除6节点后右子树的高度：" + avlTree.root.rightHeight());
        avlTree.delete(7);
        System.out.println("删除7节点后树的高度：" + avlTree.root.height());
        System.out.println("删除7节点后左子树的高度：" + avlTree.root.leftHeight());
        System.out.println("删除7节点后右子树的高度：" + avlTree.root.rightHeight());
    }
}

/**
 * 定义AvlTree
 */
class AvlTree {
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
            targetNode.value = delRightTreeMin(targetNode.right);
        }
        //当添加完一个节点后，如果rightHeight-leftHeight > 1左旋
        if (root.rightHeight() - root.leftHeight() > 1) {
            if (root.right != null && root.right.leftHeight() > root.right.rightHeight()) {
                root.right.rightHeight();
            }
            root.leftRotate();
        } else if (root.leftHeight() - root.rightHeight() > 1) {
            //当添加完一个节点后，如果leftHeight - rightHeight > 1右旋
            if (root.left != null && root.left.rightHeight() > root.left.leftHeight()) {
                //先对当前节点的左子树进行左旋
                root.left.leftRotate();
            }
            //再对当前节点进行右旋转
            root.rightRotate();
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
        //当添加完一个节点后，如果rightHeight-leftHeight > 1左旋
        if (rightHeight() - leftHeight() > 1) {
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightHeight();
            }
            leftRotate();
        } else if (leftHeight() - rightHeight() > 1) {
            //当添加完一个节点后，如果leftHeight - rightHeight > 1右旋
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                //先对当前节点的左子树进行左旋
                this.left.leftRotate();
            }
            //再对当前节点进行右旋转
            rightRotate();
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

    /**
     * 返回左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    /**
     * 返回右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    /**
     * 返回以当前节点为根节点的树的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左旋转
     */
    public void leftRotate() {
        //1.创建新节点，其值等于当前节点的值
        Node newNode = new Node(this.value);
        //2.将新节点的左子树设置为当前节点的左子树
        newNode.left = this.left;
        //3.将新节点的右子树设置为当前节点右子树的左子树
        if (this.right != null) {
            newNode.right = this.right.left;
        }
        //4.将当前节点的值替换为其右子节点的值
        if (this.right != null) {
            this.value = this.right.value;
        }
        //5.将当前节点的右子树设置为当前节点右子树的右子树
        if (this.right != null) {
            this.right = this.right.right;
        }
        //6.将当前节点的左子树设置为先前创建的新节点
        this.left = newNode;
    }

    /**
     * 右旋转
     */
    public void rightRotate() {
        Node newNode = new Node(this.value);
        newNode.right = this.right;
        if (this.left != null) {
            newNode.left = this.left.right;
        }
        if (this.left != null) {
            this.value = this.left.value;
        }
        if (this.left != null) {
            this.left = this.left.left;
        }
        this.right = newNode;
    }
}
