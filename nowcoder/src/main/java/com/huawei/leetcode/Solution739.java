package com.huawei.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日气温
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。
 * 每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution739 {

    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solution739.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int current = 0;
        while (current < T.length) {
            for (int i = current + 1; i < T.length; i++) {
                if (T[current] < T[i]) {
                    res[current] = i - current;
                    break;
                }
            }
            current++;
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            //如果栈不为空，且当前温度大于栈顶温度
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                //获取栈顶温度下标
                int preIndex = stack.pop();
                //preIndex的温度经过i-preIndex天后达到最大
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
