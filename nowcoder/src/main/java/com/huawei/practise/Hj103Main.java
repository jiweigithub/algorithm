package com.huawei.practise;

import java.util.Scanner;

/**
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，
 * 从前到后，但只能从低处往高处的桩子走。
 * 他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 * <p>
 * 本题含有多组样例输入
 * <p>
 * <p>
 * 输入描述:
 * 输入多行，先输入数组的个数，再输入相应个数的整数
 * <p>
 * 输出描述:
 * 输出结果
 * <p>
 * 示例1
 * 输入
 * 复制
 * 6
 * 2 5 1 5 4 5
 * 3
 * 3 2 1
 * 输出
 * 复制
 * 3
 * 1
 * 说明
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 * 所以这个结果是3。
 */
public class Hj103Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int count = Integer.parseInt(sc.nextLine());
            int[] arr = new int[count];
            String line = sc.nextLine();
            String[] split = line.split(" ");
            for (int i = 0; i < count; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            System.out.println(lengthOfLIS(arr));
        }
    }

    /**
     * 最长上升子序列
     * f(i) = max(f(i-1)) + 1
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
