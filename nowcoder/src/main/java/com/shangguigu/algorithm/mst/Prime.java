package com.shangguigu.algorithm.mst;

import java.util.Arrays;

/**
 * 普利姆算法求解最小生成树
 */
public class Prime {
    public static void main(String[] args) {
        //测试图是否创建成功
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //顶点个数
        int vertex = data.length;
        //邻接矩阵 10000这个大数，表示两个点不连通
        int[][] weight = new int[][]
                {       //A         B       C       D       E       F       G
                        {10000, 5, 7, 10000, 10000, 10000, 2},      //A
                        {5, 10000, 10000, 9, 10000, 10000, 3},      //B
                        {7, 10000, 10000, 10000, 8, 10000, 10000},      //C
                        {10000, 9, 10000, 10000, 10000, 4, 10000},      //D
                        {10000, 10000, 8, 10000, 10000, 5, 4},      //E
                        {10000, 10000, 10000, 4, 5, 10000, 6},      //F
                        {2, 3, 10000, 10000, 4, 6, 10000},      //G
                };
        //创建图对象
        Graph graph = new Graph(vertex);
        //创建最小生成树对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, vertex, data, weight);
        //输出图的邻接矩阵
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prime(graph, 1);
    }
}

//创建最小生成树
class MinTree {
    /**
     * 创建图的邻接矩阵
     *
     * @param graph  图对象
     * @param vertex 图的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(Graph graph, int vertex, char[] data, int[][] weight) {
        int i, j;
        //遍历顶点
        for (i = 0; i < vertex; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < vertex; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 输出图的临界矩阵
     *
     * @param graph 图对象
     */
    public void showGraph(Graph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 普利姆算法得到最小生成树
     *
     * @param graph 图
     * @param v     从哪个顶点开始
     */
    public void prime(Graph graph, int v) {
        //visited 标记节点是否被访问过 0 表示没有访问过
        int visited[] = new int[graph.vertexes];
        //把当前节点标记为已访问
        visited[v] = 1;
        //用h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //将minWeight初始化成一个大数，后面在遍历的过程中，会被替换
        int minWeight = 10000;
        //因为有vertexes个顶点，普利姆算法结束后，有vertexes-1条边
        for (int k = 1; k < graph.vertexes; k++) {
            //遍历已访问的节点
            for (int i = 0; i < graph.vertexes; i++) {
                //遍历未访问的节点
                for (int j = 0; j < graph.vertexes; j++) {
                    //如果已访问的节点与未访问节点的权值小于当前最小权值
                    if (visited[i] == 1 && visited[j] != 1 && graph.weight[i][j] < minWeight) {
                        //替换minWeight
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条最小边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值：" + minWeight);
            //将当前找到的节点标记为已访问
            visited[h2] = 1;
            //重置minWeight
            minWeight = 10000;
        }
    }
}

class Graph {
    /**
     * 图的节点个数
     */
    int vertexes;

    /**
     * 节点数据
     */
    char[] data;

    /**
     * 存放边，就是我们的邻接矩阵
     */
    int[][] weight;

    public Graph(int vertex) {
        this.vertexes = vertex;
        data = new char[vertex];
        weight = new int[vertex][vertex];
    }
}