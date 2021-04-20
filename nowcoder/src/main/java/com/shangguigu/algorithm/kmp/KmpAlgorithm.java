package com.shangguigu.algorithm.kmp;

import java.util.Arrays;

/**
 * KMP算法求解字符串匹配问题，返回第一次次匹配成功的下标,没有返回-1
 */
public class KmpAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "abba";

        int[] matchVal = getMatchVal(str2);
        System.out.println(Arrays.toString(matchVal));
    }

    /**
     * 获取一个字符串的部分匹配值
     *
     * @return
     */
    public static int[] getMatchVal(String str) {
        //创建结果数组，保存部分匹配值
        int[] result = new int[str.length()];
        //如果字符串长度为1，其部分匹配值就是0
        result[0] = 0;
        //假设右两个str,一上一下，i和j分别代表其字符位置指针
        int i = 1;
        int j = 0;
        int matchCount = 0;
        while (i < str.length()) {
            //如果str.charAt(j) != str.charAt(i) 移动上面str的指针i到下一位继续比较
            if (str.charAt(j) != str.charAt(i)) {
                //如果上一个匹配结果不为0
                if (result[i - 1] != 0) {
                    //指针i移动上次匹配结果个位置
                    i += result[i - 1];
                } else {
                    result[i] = 0;
                    i++;
                }
            } else {
                matchCount++;
                result[i] = matchCount;
                i++;
                j++;
            }
        }
        return result;
    }

}
