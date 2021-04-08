package com.shangguigu.datastructures.tree.huffman.code;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 霍夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) {
/*        String input = "i like like like java do you like a java";
        byte[] inputBytes = input.getBytes();
        System.out.println(inputBytes.length);
        System.out.println(Arrays.toString(inputBytes));
//        List<Node> nodes = getNodes(inputBytes);
//        System.out.println(nodes);
//        Node huffmanTree = createHuffmanTree(nodes);
//        huffmanTree.preOrder();
//        Map<Byte, String> huffmanCodeMap = getHuffmanCodeMap(huffmanTree, "", new StringBuilder());
//        System.out.println(huffmanCodeMap);
//        byte[] zip = zip(inputBytes, huffmanCodeMap);
//        System.out.println(zip.length);
//        System.out.println(Arrays.toString(zip));
//        System.out.println(inputBytes.length);
        byte[] zip = huffmanZip(inputBytes);
//        System.out.println(bytes.length);
//        System.out.println(Arrays.toString(bytes));
//
//        String s = byteToBinaryString((byte) -1);
//        System.out.println(s);

        byte[] bytes = deCode(huffmanCodeMap, zip);
        String result = new String(bytes);
        System.out.println(result);*/

        //测试压缩文件
        String srcFile = "d://myProject//test.png";
        String dstFile = "d://myProject//dst2.zip";
        zipFile(srcFile, dstFile);
        System.out.println("压缩完成");

        String outFile = "d://myProject//test2.png";
        unZipFile(dstFile, outFile);
        System.out.println("解压完成");

    }

    public static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTree = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodeMap = getHuffmanCodeMap(huffmanTree, "", new StringBuilder());
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

    static Map<Byte, String> huffmanCodeMap = new HashMap<>();

    /**
     * 根据霍夫曼树获取霍夫曼编码表
     *
     * @param node
     * @return
     */
    public static Map<Byte, String> getHuffmanCodeMap(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            //判断当前node是叶子节点还是非叶子节点
            if (node.data == null) {
                //递归处理
                //向左递归
                getHuffmanCodeMap(node.left, "0", stringBuilder1);
                //向右递归
                getHuffmanCodeMap(node.right, "1", stringBuilder1);
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

    /**
     * 压缩文件
     *
     * @param srcFile 待压缩问题件路径
     * @param dstFile 压缩后文件放到哪里
     */
    public static void zipFile(String srcFile, String dstFile) {
        //创建输入流
        FileInputStream fileInputStream = null;
        //创建文件输出流
        OutputStream os = null;
        //创建对象输出流
        ObjectOutputStream oos = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] bytes = new byte[fileInputStream.available()];
            //读取文件
            fileInputStream.read(bytes);
            //获取到压缩后的数据
            byte[] zipBytes = huffmanZip(bytes);
            //创建文件输出流
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //这里我们以对象流的方式写入压缩后的编码
            oos.writeObject(zipBytes);
            //写入霍夫曼编码表
            oos.writeObject(huffmanCodeMap);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解压
     *
     * @param zipFile
     * @param outFile
     */
    public static void unZipFile(String zipFile, String outFile) {
        //定义输入流
        InputStream is = null;
        ObjectInputStream ois = null;
        //定义输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            //读取byte数组
            byte[] zipBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodeMap = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = deCode(huffmanCodeMap, zipBytes);
            //创建文件输出流
            os = new FileOutputStream(outFile);
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
            while (flag && (i + count) < stringBuilder.length()) {
                String substring = stringBuilder.substring(i, i + count);
                b = deHuffmanCodeMap.get(substring);
//                if (i + count < stringBuilder.length()) {
//                    String substring = stringBuilder.substring(i, i + count);
//                    b = deHuffmanCodeMap.get(substring);
//                } else {
//                    String substring = stringBuilder.substring(i);
//                    b = deHuffmanCodeMap.get(substring);
//                }
                if (b != null) {
                    flag = false;
                } else {
                    count++;
                }
            }
            if (b != null) {
                list.add(b);
            }
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
