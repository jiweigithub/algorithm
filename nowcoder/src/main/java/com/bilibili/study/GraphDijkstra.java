package com.bilibili.study;

import java.util.*;

/**
 * 迪杰斯特拉求解最短路径问题
 */
public class GraphDijkstra {

    static Map<String, List<Node>> graph = new HashMap<>();

    public static void main(String[] args) {
        //初始化图
        {
            List<Node> a_Adjacent = new ArrayList<>();
            a_Adjacent.add(new Node("B", 5));
            a_Adjacent.add(new Node("C", 1));
            graph.put("A", a_Adjacent);
            List<Node> b_Adjacent = new ArrayList<>();
            b_Adjacent.add(new Node("A", 5));
            b_Adjacent.add(new Node("C", 2));
            b_Adjacent.add(new Node("D", 1));
            graph.put("B", b_Adjacent);
            List<Node> c_Adjacent = new ArrayList<>();
            c_Adjacent.add(new Node("A", 1));
            c_Adjacent.add(new Node("B", 2));
            c_Adjacent.add(new Node("D", 4));
            c_Adjacent.add(new Node("E", 8));
            graph.put("C", c_Adjacent);
            List<Node> d_Adjacent = new ArrayList<>();
            d_Adjacent.add(new Node("B", 1));
            d_Adjacent.add(new Node("C", 4));
            d_Adjacent.add(new Node("E", 3));
            d_Adjacent.add(new Node("F", 6));
            graph.put("D", d_Adjacent);
            List<Node> e_Adjacent = new ArrayList<>();
            e_Adjacent.add(new Node("C", 8));
            e_Adjacent.add(new Node("D", 3));
            graph.put("E", e_Adjacent);
            List<Node> f_Adjacent = new ArrayList<>();
            f_Adjacent.add(new Node("D", 6));
            graph.put("F", f_Adjacent);
        }
        Map<String, Integer> distance = new LinkedHashMap<>();
        Map<String, String> parent = bfs(distance, graph, "A");
        parent.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        System.out.println("输出各个顶点到起始点的距离");
        distance.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

        String target = "B";
        while (target != null) {
            System.out.println(target);
            target = parent.get(target);
        }
    }

    /**
     * 初始化每个顶点到起始点的距离为正无穷
     *
     * @param graph
     * @param start
     */
    public static Map<String, Integer> initDistance(Map<String, Integer> distance, Map<String, List<Node>> graph, String start) {
        //初始化各个点到起始点的距离
        distance.put(start, 0);
        graph.forEach((vertex, nodes) -> {
            if (!vertex.equals(start)) {
                distance.put(vertex, Integer.MAX_VALUE);
            }
        });
        return distance;
    }

    public static Map<String, String> bfs(Map<String, Integer> distance, Map<String, List<Node>> graph, String start) {
        //已经访问过的节点
        Set<String> seen = new HashSet<>();
        //初始化距离
        initDistance(distance, graph, start);
        //记录当前节点对应的前驱节点
        Map<String, String> parent = new LinkedHashMap<>(16);
        //创建队列
        Queue<Node> queue = new PriorityQueue<>();
        Node startNode = new Node(start, 0);
        queue.offer(startNode);
        parent.put(start, null);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            //从队列中取出一个顶点
            Node pair = queue.poll();
            int dist = pair.dist;
            String vertex = pair.vertex;
            //标记当前节点已经被访问
            seen.add(vertex);
            //获取当前节点的所有邻接节点
            List<Node> nodes = graph.get(vertex);
            for (Node node : nodes) {
                //如果当前邻接节点还未被访问
                if (!seen.contains(node.vertex)) {
                    //当前邻接节点到start的距离小于已经记录的距离
                    if (dist + node.dist < distance.get(node.vertex)) {
                        //记录节点到起始点的距离
                        distance.put(node.vertex, dist + node.dist);
                        //修改当前节点到起始点的距离
                        node.dist += dist;
                        //将该节点放入队列
                        queue.offer(node);
                        //记录节点的前驱节点
                        parent.put(node.vertex, vertex);

                    }
                }
            }
        }
        return parent;
    }

}

class Node implements Comparable<Node> {
    /**
     * 距离
     */
    int dist;
    /**
     * 顶点
     */
    String vertex;

    public Node(String vertex, int dist) {
        this.dist = dist;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}
