package com.huawei.leetcode;

/**
 * 跳跃游戏II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [2,3,0,1,4]
 * 输出: 2
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */
public class Solution45 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.descJump(arr));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        //每一步可到达的边界
        int end = 0;
        //最远可到达位置
        int maxPosition = 0;
        //走的步数
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            //贪心，总是获取最远可到达的位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 倒着计算步骤，从最后一个位置向前跳，找可以到达最后一个位置的点
     *
     * @param nums
     * @return
     */
    public int descJump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        //当所处位置大于0
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                //如果当前点的下标加可走步数大于等于position,说明可从该点直接跳到position
                if (i + nums[i] >= position) {
                    //当前所处位置到i
                    position = i;
                    //步数加一
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
