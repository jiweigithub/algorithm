package com.huawei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 航班预定统计
 * <p>
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 
 * 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * <p>
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 * <p>
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 */
public class Solution1109 {

    public static void main(String[] args) {
        int[][] bookings = new int[][]{{
                2, 2, 30
        }, {2, 2, 45}};
        Solution1109 solution1109 = new Solution1109();
        solution1109.corpFlightBookings(bookings, 2);
    }

    /**
     * 暴力统计
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //航班号座位数统计，key表示航班号，v表示改航班号上的预定的座位数
        Map<Integer, Integer> seatsCount = new HashMap<>(16);
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int seat = booking[2];
            int x = end - start;
            for (int i = 0; i <= x; i++) {
                if (seatsCount.containsKey(start + i)) {
                    seatsCount.put(start + i, seatsCount.get(start + i) + seat);
                } else {
                    seatsCount.put(start + i, seat);
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (seatsCount.containsKey(i + 1)) {
                ans[i] = seatsCount.get(i + 1);
            }
        }
        return ans;
    }
}
