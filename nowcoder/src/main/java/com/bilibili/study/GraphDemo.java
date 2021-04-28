package com.bilibili.study;

import java.util.*;

/**
 * 图的BFS和DFS
 * <p>
 * BFS
 * 1、从起始点(任意点)u开始,逐个访问u的所有邻接节点;
 * 2、如果节点已经被访问，该节点，接着访问u的下一个邻接节点,直到u的所有邻接节点都被访问过;
 * 此时第一层结束;
 * 3、设u的邻接节点为v，重复1，2步骤，直到图的所有节点都被访问过为止；
 * 为了实现BFS，我们需要借助 队列 其特点是先进先出
 */
public class GraphDemo {

    static Map<String, String[]> graph = new HashMap<>();

    public static void main(String[] args) {
        //初始化图
        {
            graph.put("A", new String[]{"B", "C"});
            graph.put("B", new String[]{"A", "C", "D"});
            graph.put("C", new String[]{"A", "B", "D", "E"});
            graph.put("D", new String[]{"B", "C", "E", "F"});
            graph.put("E", new String[]{"C", "D"});
            graph.put("F", new String[]{"D"});
        }
//        System.out.println(graph.keySet());
//        System.out.println(Arrays.toString(graph.get("A")));
//        bfs(graph, "E");
        bfs(graph, "E");
    }

    public static void bfs(Map<String, String[]> graph, String start) {
        //已经访问过的节点
        Set<String> seen = new HashSet<>();
        //记录当前节点对应的前驱节点
        Map<String, String> parent = new LinkedHashMap<>(16);
        //创建队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        seen.add(start);
        parent.put(start, null);
        while (!queue.isEmpty()) {
            //从队列中取出一个顶点
            String vertex = queue.poll();
            //获取当前节点的所有邻接节点
            String[] nodes = graph.get(vertex);
            for (String node : nodes) {
                //如果当前节点还未被访问
                if (!seen.contains(node)) {
                    //将该节点放入队列
                    queue.offer(node);
                    //标记为已访问
                    seen.add(node);
                    //记录节点的前驱节点
                    parent.put(node, vertex);
                }
            }
            System.out.println(vertex);
        }
        parent.forEach((k, v) -> {
            System.out.println(v + "->" + k);
        });
        String target = "B";
        while (target != null) {
            System.out.println(target);
            target = parent.get(target);
        }
    }

    public static void dfs(Map<String, String[]> graph, String start) {
        //已经访问过的节点
        Set<String> seen = new HashSet<>();
        //创建栈
        Deque<String> stack = new LinkedList<>();
        stack.push(start);
        seen.add(start);
        while (!stack.isEmpty()) {
            //从栈中取出一个顶点
            String vertex = stack.pop();
            //获取当前节点的所有邻接节点
            String[] nodes = graph.get(vertex);
            for (String node : nodes) {
                //如果当前节点还未被访问
                if (!seen.contains(node)) {
                    //将该节点放入栈
                    stack.push(node);
                    //标记为已访问
                    seen.add(node);
                }
            }
            System.out.println(vertex);
        }
    }
}
