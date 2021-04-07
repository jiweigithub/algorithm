package com.shangguigu.datastructures.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 霍夫曼树
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);
        huffmanTree.preOrder();
    }

    /**
     * 创建霍夫曼树
     *
     * @param arr
     */
    public static Node createHuffmanTree(int[] arr) {
        //1.遍历arr数组
        //2.将arr的每个元素构建成一个node
        //3.将Node放入到ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int v : arr) {
            Node node = new Node(v);
            nodes.add(node);
        }
        return buildHuffmanTree(nodes);
    }

    private static Node buildHuffmanTree(ArrayList<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            //取出根节点权值最小的两颗二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;

            //从arrayList中删除处理过的二叉树
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

/**
 * 创建节点类
 */
class Node implements Comparable<Node> {
    /**
     * 节点权值
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

    @Override
    public int compareTo(Node o) {
        //从小到达排序
        return this.value - o.value;
        //从大到小排序
//        return -(this.value - o.value);
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
