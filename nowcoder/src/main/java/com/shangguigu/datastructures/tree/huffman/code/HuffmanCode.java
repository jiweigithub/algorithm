package com.shangguigu.datastructures.tree.huffman.code;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 霍夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String input = "i like like like java do you like a java";
        byte[] inputBytes = input.getBytes();
        System.out.println(inputBytes.length);
        System.out.println(Arrays.toString(inputBytes));
        List<Node> nodes = getNodes(inputBytes);
//        System.out.println(nodes);
        Node huffmanTree = createHuffmanTree(nodes);
//        huffmanTree.preOrder();
        Map<Byte, String> huffmanCodeMap = getHuffmanCodeMap(huffmanTree, new HashMap<>(), "", new StringBuilder());
//        System.out.println(huffmanCodeMap);
        byte[] zip = zip(inputBytes, huffmanCodeMap);
//        System.out.println(zip.length);
//        System.out.println(Arrays.toString(zip));
//        System.out.println(inputBytes.length);
//        byte[] bytes = huffmanZip(inputBytes);
//        System.out.println(bytes.length);
//        System.out.println(Arrays.toString(bytes));
//
//        String s = byteToBinaryString((byte) -1);
//        System.out.println(s);

        byte[] bytes = deCode(huffmanCodeMap, zip);
        String result = new String(bytes);
        System.out.println(result);
    }

    public static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTree = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodeMap = getHuffmanCodeMap(huffmanTree, new HashMap<>(), "", new StringBuilder());
        return zip(bytes, huffmanCodeMap);
    }

    /**
     * 获取Node集合
     *
     * @param bytes
     */
    public static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, AtomicInteger> byteCountMap = new HashMap<>();
        for (byte b : bytes) {
            byteCountMap.computeIfAbsent(b, key -> new AtomicInteger()).getAndIncrement();
        }
        byteCountMap.forEach((k, v) -> {
            Node node = new Node(k, v.get());
            nodes.add(node);
        });
        return nodes;
    }

    /**
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 根据霍夫曼树获取霍夫曼编码表
     *
     * @param node
     * @return
     */
    public static Map<Byte, String> getHuffmanCodeMap(Node node, Map<Byte, String> huffmanCodeMap, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            //判断当前node是叶子节点还是非叶子节点
            if (node.data == null) {
                //递归处理
                //向左递归
                getHuffmanCodeMap(node.left, huffmanCodeMap, "0", stringBuilder1);
                //向右递归
                getHuffmanCodeMap(node.right, huffmanCodeMap, "1", stringBuilder1);
            } else {
                //找到了叶子节点
                huffmanCodeMap.put(node.data, stringBuilder1.toString());
            }
        }
        return huffmanCodeMap;
    }

    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodeMap.get(b));
        }
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] zipBytes = new byte[len];
        int index = 0;
        //因为每8位对应一个byte，所以步长+8
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            byte aByte = (byte) Integer.parseInt(strByte, 2);
            zipBytes[index] = aByte;
            index++;
        }
        return zipBytes;
    }

    public static byte[] deCode(Map<Byte, String> huffmanCodeMap, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            if (i == huffmanBytes.length - 1) {
                stringBuilder.append(Integer.toBinaryString(huffmanBytes[i]));
            } else {
                stringBuilder.append(byteToBinaryString(huffmanBytes[i]));
            }
        }
        //把字符串按照指定的霍夫曼编码进行解码
        Map<String, Byte> deHuffmanCodeMap = new HashMap<>();
        huffmanCodeMap.forEach((k, v) -> {
            deHuffmanCodeMap.put(v, k);
        });

        //创建一个集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i理解成就是索引
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String substring = stringBuilder.substring(i, i + count);
                b = deHuffmanCodeMap.get(substring);
                if (b != null) {
                    flag = false;
                } else {
                    count++;
                }
            }
            list.add(b);
            i += count;
        }
        //当for循环结束后，list中就存放了所有的字符
        byte[] result = new byte[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    /**
     * byte转8位二进制
     *
     * @param num
     * @return
     */
    public static String byteToBinaryString(byte num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }

    /**
     * byte转8位二进制
     *
     * @param num
     * @return
     */
    public static String byteToBitString(boolean flag, byte num) {
        int temp = num;
        if (flag) {
            temp &= 256;
        }
        String s = Integer.toBinaryString(temp);
        if (flag) {
            return s.substring(s.length() - 8);
        } else {
            return s;
        }
    }
}

class Node implements Comparable<Node> {
    /**
     * 存放数据本身
     */
    Byte data;

    /**
     * 权值(表示数据出现的次数)
     */
    int weight;

    Node left;

    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
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
