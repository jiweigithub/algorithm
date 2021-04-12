package com.shangguigu.datastructures.graph;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 邻接矩阵实现图
 */
public class Graph {

    /**
     * 存储顶点集合
     */
    private ArrayList<String> vertexList;

    /**
     * 存储图对应的邻接矩阵
     */
    private int[][] edges;

    /**
     * 记录某个节点是否被访问
     */
    private boolean[] isVisited;

    /**
     * 表示边的个数
     */
    private int numOfEdges;

    /**
     * 构造器
     *
     * @param n 顶点个数
     */
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
    }

    /**
     * 获取当前节点的第一个邻接节点的下标
     *
     * @param index 当前节点下标
     * @return 如果存在返回对应下标，否则返回-1
     */
    public int getFirstAdjacent(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            //如果当前节点和j节点的边是存在的
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextAdjacent(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     */
    public void dfs(boolean[] isVisited, int i) {
        //首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将该节点设置为已访问
        isVisited[i] = true;
        //获取当前节点的第一个邻接节点w
        int w = getFirstAdjacent(i);
        //如果邻接节点存在
        while (w != -1) {
            //如果未被访问过
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w已经被访问过,查找当前节点的下一个邻接节点
            w = getNextAdjacent(i, w);
        }
    }

    /**
     * 对dfs进行重载，遍历所有节点，进行dfs
     */
    public void dfs() {
        //遍历所有的节点，进行dfs
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //图中常用的方法

    /**
     * 返回节点的个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 获得边的数目
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回节点i（下标）对应的数据
     *
     * @param i 节点下标
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回两个顶点间的权值
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 显示矩阵
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }


    /**
     * 插入顶点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     点在ArrayList中的下标
     * @param v2     点在ArrayList中的下标
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public static void main(String[] args) {
        //测试图的创建
        //节点的个数
        int n = 5;
        String[] vertexValues = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(5);
        //循环的添加顶点
        for (String vertex : vertexValues) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B,A-C,B-C,B-D,B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //显示邻接矩阵
        graph.showGraph();

        graph.dfs();
    }


}
