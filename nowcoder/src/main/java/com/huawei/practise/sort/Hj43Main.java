package com.huawei.practise.sort;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 * <p>
 * <p>
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 0, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * <p>
 * <p>
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
 * <p>
 * <p>
 * 本题含有多组数据。
 * <p>
 * 输入描述:
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * <p>
 * 输出描述:
 * 左上角到右下角的最短路径，格式如样例所示。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出
 * 复制
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 */

public class Hj43Main {

    /**
     * 深度遍历缓存
     */
    static Stack<Node> nodes = new Stack<>();

    /**
     * 记录已走路径
     */
    static Stack<String> nodePath = new Stack<>();
    /**
     * 记录最小路径
     */
    static Stack<String> minNodePath = new Stack<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String mn = sc.nextLine();
            String[] mnArray = mn.split(" ");
            int m = Integer.parseInt(mnArray[0]);
            int n = Integer.parseInt(mnArray[1]);
            int[][] matrix = new int[m][n];
            for (int i = 0; i < n; i++) {
                String mi = sc.nextLine();
                String[] miArray = mi.split(" ");
                for(int j=0; j<miArray.length; j++) {
                    matrix[i][j] = Integer.parseInt(miArray[j]);
                }
            }
            nodes.clear();
            minNodePath.clear();
            nodePath.clear();
            nodes.push(new Node(0, 0, 3, 1));
            test(n - 1, m - 1, matrix);
            for (String o : minNodePath
            ) {
                System.out.println(o);
            }
        }
    }


    public static void test(int n, int m, int[][] tab) {
        // 栈中无元素 递归结束
        if (nodes.size() <= 0) {
            return;
        }
        // 出栈 深度优先遍历开始 （广度优先遍历更适合做这道题，我两种都写了）
        Node pop = nodes.pop();
        int x = pop.x;
        int y = pop.y;
        int sum = pop.sum;
        int flag = pop.flag;
        // 若回溯则释放已保存路径  释放大小=回溯的步长
        while (sum - 1 < nodePath.size()) {
            nodePath.pop();
        }
        // 判断是否死循环，因为前后左右都能走，所以要排除死循环可能，即绕圈走
        if (notHasPath(x, y)) {
            nodePath.push(pop.toString());
        }
        // 终点结束 记录最小路径
        if (x == n && y == m) {
            int min = minNodePath.size();
            int np = nodePath.size();
            if (min == 0 || np < min) {
                minNodePath = (Stack<String>) nodePath.clone();
            }
        }
        // 下
        if (flag != 3 && notHasPath(x, y - 1) && (y - 1) >= 0 && tab[x][y - 1] == 0) {
            Node node = new Node(x, y - 1, 1, sum + 1);
            nodes.push(node);
        }
        // 右
        if (flag != 4 && notHasPath(x + 1, y) && (x + 1) <= n && tab[x + 1][y] == 0) {
            Node node = new Node(x + 1, y, 2, sum + 1);
            nodes.push(node);
        }
        // 上
        if (flag != 1 && notHasPath(x, y + 1) && (y + 1) <= m && tab[x][y + 1] == 0) {
            Node node = new Node(x, y + 1, 3, sum + 1);
            nodes.push(node);
        }
        // 左
        if (flag != 2 && notHasPath(x - 1, y) && (x - 1) >= 0 && tab[x - 1][y] == 0) {
            Node node = new Node(x - 1, y, 4, sum + 1);
            nodes.push(node);
        }
        test(n, m, tab);
    }

    /**
     * 判断路径是否已走过
     */

    public static boolean notHasPath(int x, int y) {
        if (nodePath.contains(Node.toString(x, y))){
            return false;
        }
        return true;
    }

    /**
     * 定义一个节点
     */
    static class Node {
        // x y 坐标
        int x;
        int y;
        // 1上 2右  3下 4左
        int flag;
        // 当前已走步数
        int sum;

        public Node(int x, int y, int flag, int sum) {
            this.x = x;
            this.y = y;
            this.flag = flag;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        public static String toString(int x, int y) {
            return "(" + x + "," + y + ")";
        }
    }
}
