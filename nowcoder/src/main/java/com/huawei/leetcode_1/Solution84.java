package com.huawei.leetcode_1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 柱状图的最大面积
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 */
public class Solution84 {

    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        int[] heights = {1, 2, 3, 4, 5};
        int ans = solution84.largestRectangleArea(heights);
        System.out.println(ans);
    }

    /**
     * 借助栈来辅助计算
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int area = 0;
        Deque<Integer> stack = new LinkedList<>();
        //遍历高度数组
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                //弹出比当前高度高的栈顶元素，并获取其高度
                int height = heights[stack.pop()];
                //如果弹出栈顶元素高度与新的栈顶元素高度相同
                while (!stack.isEmpty() && height == heights[stack.peek()]) {
                    //将新的栈顶元素弹出
                    stack.pop();
                }
                int width;
                //如果栈已经空了
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    //宽度等于当前元素下标-新栈顶元素下标-1
                    width = i - stack.peek() - 1;
                }
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }
        //一次遍历结束后，处理站内剩余的元素
        while (!stack.isEmpty()) {
            //弹出比当前高度高的栈顶元素，并获取其高度
            int height = heights[stack.pop()];
            //如果弹出栈顶元素高度与新的栈顶元素高度相同
            while (!stack.isEmpty() && height == heights[stack.peek()]) {
                //将新的栈顶元素弹出
                stack.pop();
            }
            int width;
            //如果栈已经空了,说明只剩高度最小矩形面积还未得到，此时一定可以向左向右扩散到边界，width = len
            if (stack.isEmpty()) {
                width = len;
            } else {
                //如果不为空，我们可以认为高度数组边界之外还有一个高度为0的元素其下标就是数组长度
                //宽度等于当前元素下标-新栈顶元素下标-1
                width = len - stack.peek() - 1;
            }
            area = Math.max(area, height * width);
        }
        return area;
    }

    /**
     * 借助栈来辅助计算,增加边界哨兵，减少重复的代码
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaSentinel(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int area = 0;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        len += 2;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        //遍历高度数组
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peek()]) {
                //弹出比当前高度高的栈顶元素，并获取其高度
                int height = heights[stack.pop()];
                //如果弹出栈顶元素高度与新的栈顶元素高度相同
                while (!stack.isEmpty() && height == heights[stack.peek()]) {
                    //将新的栈顶元素弹出
                    stack.pop();
                }
                //宽度等于当前元素下标-新栈顶元素下标-1
                int width = i - stack.peek() - 1;
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }
        return area;
    }

    /**
     * 暴力解法求解,高度固定，比较每个高度下最大矩形的面积
     *
     * @param heights
     * @return
     */
    public int violenceSolution(int[] heights) {
        int len = heights.length;
        //特别判定
        if (len == 0) {
            return 0;
        }
        int ans = 0;
        //遍历整个高度数组
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            int current = heights[i];
            //从当前下标开始向左找，找到第一个比他小的高度
            while (left - 1 >= 0 && heights[left - 1] >= current) {
                left--;
            }
            //从当前下标开始向右找，找到第一个比他小的高度
            while (right + 1 < len && heights[right + 1] >= current) {
                right++;
            }
            //比较当前高度下矩形面积与已知的矩形最大面积
            ans = Math.max(ans, (right - left + 1) * current);
        }
        return ans;
    }
}
