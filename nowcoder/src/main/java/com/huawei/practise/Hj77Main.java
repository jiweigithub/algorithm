package com.huawei.practise;


import java.util.*;

/**
 * 火车进站
 * <p>
 * 题目描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，
 * 同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 输入描述:
 * 有多组测试用例，每一组第一行输入一个正整数N（0
 * <p>
 * 输出描述:
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 3
 * 1 2 3
 * 输出
 * 复制
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 说明
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 */
public class Hj77Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int count = scanner.nextInt();
            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = scanner.nextInt();
            }
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            int j = 0;
            solution(result, temp, arr, count, stack, i, j);
            List<String> ans = new ArrayList<>();
            for (List<Integer> paths : result) {
                StringBuilder sb = new StringBuilder();
                for (Integer path : paths) {
                    sb.append(path).append(" ");
                }
                ans.add(sb.toString());
            }
            Collections.sort(ans);
            for (String path : ans) {
                System.out.println(path);
            }
        }
    }

    /**
     * @param result 结果集
     * @param temp   临时路径
     * @param arr    入站序列
     * @param n      火车数
     * @param stack  火车站
     * @param i      出站序列
     * @param j      入站序列
     */
    public static void solution(List<List<Integer>> result, List<Integer> temp, int[] arr, int n, Stack<Integer> stack, int i, int j) {
        //base case:全部出栈入栈完毕，则存入结果集
        if (i == n && j == n) {
            result.add(new ArrayList<Integer>(temp));
            temp = new ArrayList<>();
            return;
        }
        //选择进站（入栈序列不为空）:入栈序列不为空，就可以选择。选择之后递归，之后再撤销选择
        if (j != n) {
            stack.push(arr[j]);
            solution(result, temp, arr, n, stack, i, j + 1);
            stack.pop();
        }
        //栈顶的元素出栈：也是可选的(栈不空就可以操作)
        if (!stack.isEmpty()) {
            int x = stack.pop();
            temp.add(x);
            solution(result, temp, arr, n, stack, i + 1, j);
            //再去除最后一个
            temp.remove(temp.size() - 1);
            //再压进去
            stack.push(x);
        }
    }
}
