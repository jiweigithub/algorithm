package com.huawei.practise;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 迷宫问题
 * <p>
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
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] maze;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int m = Integer.parseInt(s1[0]);
            int n = Integer.parseInt(s1[1]);
            maze = new int[m][n];
            for (int i = 0; i < m; i++) {
                String s2 = scanner.nextLine();
                String[] s3 = s2.split(" ");
                for (int j = 0; j < s3.length; j++) {
                    maze[i][j] = Integer.parseInt(s3[j]);
                }
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            System.out.println("递归回溯走入迷宫：" + dateFormat.format(new Date()));
            setWay(maze, 0, 0, m, n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (maze[i][j] == 2) {
                        System.out.println("(" + i + "," + j + ")");
                    }
                }
            }
            System.out.println("走出迷宫：" + dateFormat.format(new Date()));

            System.out.println("BFS走入迷宫：" + dateFormat.format(new Date()));
            bfs(maze, "0,0");
            System.out.println("BFS走出迷宫：" + dateFormat.format(new Date()));
        }
    }

    /**
     * @param maze 表示迷宫
     * @param i    从哪个位置开始找
     * @param j
     * @return 如果找到通路，返回true,否则false
     */
    public static boolean setWay(int[][] maze, int i, int j, int m, int n) {
        //说明通路已经找到
        if (maze[m-1][n-1] == 2) {
            return true;
        } else {
            //如果当前点还未走过
            if (maze[i][j] == 0) {
                //按照策略走下->右->上->左
                //假定该点是可以走通的
                maze[i][j] = 2;
                if (i + 1 < m && setWay(maze, i + 1, j, m, n)) {
                    //向下走
                    return true;
                } else if (j + 1 < n && setWay(maze, i, j + 1, m, n)) {
                    //向右走
                    return true;
                } else if (i - 1 > 0 && setWay(maze, i - 1, j, m, n)) {
                    //向上走
                    return true;
                } else if (j - 1 > 0 && setWay(maze, i, j - 1, m, n)) {
                    //向左走
                    return true;
                } else {
                    //说明该点是走不通的
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static void bfs(int[][] maze, String start) {
        //已经访问过的点
        Set<String> seen = new HashSet<>();
        //记录当前节点的前驱节点
        Map<String, String> preLocal = new LinkedHashMap<>();
        //创建队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        seen.add(start);
        preLocal.put(start, null);
        while (!queue.isEmpty()) {
            //从队列中取出一个顶点
            String vertex = queue.poll();
            //获取当前节点的所有邻接节点
            String[] split = vertex.split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            //得到当前节点的所有邻接节点
            Set<String> nodes = allAdjacent(maze, x, y);
            for (String node : nodes) {
                //如果该邻接节点还未被访问
                if (!seen.contains(node)) {
                    //将该节点放入队列
                    queue.offer(node);
                    //标记为已访问
                    seen.add(node);
                    //记录节点的前驱节点
                    preLocal.put(node, vertex);
                }
            }
        }
        List<String> result = new ArrayList<>();
        String target = (maze.length - 1) + "," + (maze.length - 1);
        while (target != null) {
            result.add("(" + target + ")");
            target = preLocal.get(target);
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }

    public static Set<String> allAdjacent(int[][] maze, int x, int y) {
        Set<String> adjacents = new HashSet<>();
        //左节点
        if (x - 1 >= 0 && maze[x - 1][y] != 1) {
            String node = x - 1 + "," + y;
            adjacents.add(node);
        }
        //右节点
        if (x + 1 < maze.length && maze[x + 1][y] != 1) {
            String node = x + 1 + "," + y;
            adjacents.add(node);
        }
        //上节点
        if (y - 1 >= 0 && maze[x][y - 1] != 1) {
            String node = x + "," + (y - 1);
            adjacents.add(node);
        }
        //下节点
        if (y + 1 < maze[0].length && maze[x][y + 1] != 1) {
            String node = x + "," + (y + 1);
            adjacents.add(node);
        }
        return adjacents;
    }
}
