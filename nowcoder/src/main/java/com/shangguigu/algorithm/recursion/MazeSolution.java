package com.shangguigu.algorithm.recursion;

/**
 * 迷宫问题（使用递归解决）
 */
public class MazeSolution {

    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        //地图
        int[][] maze = new int[8][7];
        //使用1表示墙壁
        //先把上下全部置为1
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        //把左右全部置为1
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }

        //设置挡板，1表示
        maze[3][1] = 1;
        maze[3][2] = 1;

        //设置挡板，1表示
        maze[5][3] = 1;
        maze[5][4] = 1;
        maze[5][5] = 1;

        //输出地图
        printMaze(maze);

        //使用递归回溯给小球找路
        setWay(maze, 1, 1);
        System.out.println("小球走过并标记过的地图");
        //输出新的地图,小球走过，并标识过的地图
        printMaze(maze);
    }

    private static void printMaze(int[][] maze) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //1.maze表示迷宫
    //2. i,j 表示出发点
    //3.如果小球能到maze[6][5]出口位置，则说明通路找到。
    //4.当maze[i][j] == 0表示该点还没有走过，当为2时表示可以走，当为3时表示该点已经走过，但是走不通
    //5.在走迷宫时，需要确定一个策略(方法) 先走下->右->上->左，如果该点走不通，再回溯

    /**
     * @param maze 表示迷宫
     * @param i    从哪个位置开始找
     * @param j
     * @return 如果找到通路，返回true,否则false
     */
    public static boolean setWay(int[][] maze, int i, int j) {
        System.out.println("小球走的记录");
        printMaze(maze);
        //说明通路已经找到
        if (maze[6][5] == 2) {
            return true;
        } else {
            //如果当前点还未走过
            if (maze[i][j] == 0) {
                //按照策略走下->右->上->左
                //假定该点是可以走通的
                maze[i][j] = 2;
                if (setWay(maze, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay(maze, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(maze, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(maze, i, j - 1)) {
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

}
