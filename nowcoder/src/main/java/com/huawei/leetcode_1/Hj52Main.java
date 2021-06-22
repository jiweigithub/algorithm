package com.huawei.leetcode_1;

import java.util.Scanner;

/**
 * 字符串编辑距离
 * <p>
 * 解答：查看
 * https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-by-leetcode-solution/
 */
public class Hj52Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String word1 = scanner.nextLine();
            String word2 = scanner.nextLine();
            int i = levenshteinDistance(word1, word2);
            System.out.println(i);
        }
    }

    /**
     * 状态转移方程：
     * D[i][j],表示word1的前i个字符 变化到word2的前j个字符的编辑距离
     * 由于
     * word1的插入和word2的删除等价 dog,doged 即可以 dog+e+d 也可以 doge-e-d
     * word2的插入和word1的删除等价 同上
     * word1的编辑和word2的编辑等价 cat cad 即可以 cat->cad 也可以 cad -> cat
     * D[i][j] = min(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]) // word1的第i个字符和word2的第j个字符相同
     * D[i][j] = min(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]+1) //word1的第i个字符和word2的第j个字符不相同
     * @param word1
     * @param word2
     * @return
     */
    public static int levenshteinDistance(String word1, String word2) {
        //字符串word1的长度
        int m = word1.length();
        //字符串word2的长度
        int n = word2.length();
        //如果有任意一个字符串为空,则返回m+n,例如 word1=="abc";, word2==""; word1->word2 需要三步操作 abc->ab->a->""
        if (m * n == 0) {
            return m + n;
        }
        //定义二维数组，记录最最优解，其中维度x,y分别代表word1,word2字符串的第几个字符
        int[][] dp = new int[m + 1][n + 1];
        //边界初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        //计算所有dp解的值
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                //操作word1
                int left = dp[i - 1][j] + 1;
                //操作word2
                int down = dp[i][j - 1] + 1;
                //word1和word2的上一个字符位置的编辑长度
                int left_down = dp[i - 1][j - 1];
                //如果word1的当前字符和word2的当前字符不相等（因为i和j代表的是第几个字符，而字符串charAt是按下标走的，所以都要-1）
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    //则在上一个字符位置的编辑长度上+1，否则无需做任何操作
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[m][n];
    }
}
