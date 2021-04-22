package com.shangguigu.algorithm.greedy;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        HashMap<String, Set<String>> bordCastMap = new HashMap<>();
        String[] k1 = {"北京", "上海", "天津"};
        String[] k2 = {"广州", "北京", "深圳"};
        String[] k3 = {"成都", "上海", "杭州"};
        String[] k4 = {"上海", "天津"};
        String[] k5 = {"杭州", "大连"};
        Set<String> k1Set = new HashSet<>(Arrays.asList(k1));
        Set<String> k2Set = new HashSet<>(Arrays.asList(k2));
        Set<String> k3Set = new HashSet<>(Arrays.asList(k3));
        Set<String> k4Set = new HashSet<>(Arrays.asList(k4));
        Set<String> k5Set = new HashSet<>(Arrays.asList(k5));
        bordCastMap.put("K1", k1Set);
        bordCastMap.put("K2", k2Set);
        bordCastMap.put("K3", k3Set);
        bordCastMap.put("K4", k4Set);
        bordCastMap.put("K5", k5Set);
        Set<String> allAreas = new HashSet<>();
        allAreas.addAll(k1Set);
        allAreas.addAll(k2Set);
        allAreas.addAll(k3Set);
        allAreas.addAll(k4Set);
        allAreas.addAll(k5Set);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("贪心开始："+dateFormat.format(new Date()));
        Set<String> solution = solution(bordCastMap, allAreas);
        System.out.println("贪心结束："+dateFormat.format(new Date()));
        System.out.println(solution);
    }

    private static Set<String> solution(HashMap<String, Set<String>> bordCastMap, Set<String> allAreas) {
        Set<String> solution = new HashSet<>();
        while (allAreas.size() > 0) {
            String maxKey = getMaxKey(bordCastMap, allAreas);
            solution.add(maxKey);
            Set<String> strings = bordCastMap.get(maxKey);
            strings.clear();
        }
        return solution;
    }


    private static String getMaxKey(HashMap<String, Set<String>> bordCastMap, Set<String> allAreas) {
        int maxSize = 0;
        String maxKey = null;
        List<String> maxIntersection = new ArrayList<>();
        for (String key : bordCastMap.keySet()) {
            List<String> tempIntersection = new ArrayList<>(bordCastMap.get(key));
            tempIntersection.retainAll(allAreas);
            if (maxSize < tempIntersection.size()) {
                maxSize = tempIntersection.size();
                maxIntersection = tempIntersection;
                maxKey = key;
            }
        }
        allAreas.removeAll(maxIntersection);
        return maxKey;
    }
}
