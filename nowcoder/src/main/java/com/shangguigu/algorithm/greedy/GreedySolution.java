package com.shangguigu.algorithm.greedy;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * 贪心算法
 */
public class GreedySolution {

    public static void main(String[] args) {
        String[] k1 = {"北京", "上海", "天津"};
        String[] k2 = {"广州", "北京", "深圳"};
        String[] k3 = {"成都", "上海", "杭州"};
        String[] k4 = {"上海", "天津"};
        String[] k5 = {"杭州", "大连"};
        List<String[]> allPlat = new ArrayList<>();
        allPlat.add(k1);
        allPlat.add(k2);
        allPlat.add(k3);
        allPlat.add(k4);
        allPlat.add(k5);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("贪心开始："+dateFormat.format(new Date()));
        Set<Integer> solution = solution(allPlat);
        System.out.println("贪心结束："+dateFormat.format(new Date()));
        System.out.println(solution);
    }

    public static Set<Integer> solution(List<String[]> allPlat) {
        Set<Integer> solution = new HashSet<>();
        Set<String> solutionArea = new HashSet<>();
        //获得所有未覆盖的地区
        Set<String> allAreas = new HashSet<>();
        for (String[] strings : allPlat) {
            allAreas.addAll(Arrays.asList(strings));
        }
        int i = 0;
        while (i < allPlat.size()) {
            int bestIndex = getBestIndex(allAreas, allPlat);
            solutionArea.addAll(Arrays.asList(allPlat.get(bestIndex)));
            solution.add(bestIndex);
            String[] bestIntersection = allPlat.get(bestIndex);
            Arrays.fill(bestIntersection, "");
            i++;
        }
        return solution;
    }

    public static int getBestIndex(Set<String> allAreas, List<String[]> allPlat) {
        int maxSize = 0;
        int maxIndex = 0;
        List<String> maxIntersection = new ArrayList<>();
        for (int i = 0; i < allPlat.size(); i++) {
            int finalI = i;
            List<String> intersection = allAreas.stream().filter(item -> {
                String[] strings = allPlat.get(finalI);
                List<String> list = new ArrayList<>(Arrays.asList(strings));
                return list.contains(item);
            }).collect(toList());
            if (maxSize < intersection.size()) {
                maxSize = intersection.size();
                maxIndex = i;
                maxIntersection = intersection;
            }
        }
        allAreas.removeAll(maxIntersection);
        return maxIndex;
    }


}
