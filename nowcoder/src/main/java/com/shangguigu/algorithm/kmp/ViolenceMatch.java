package com.shangguigu.algorithm.kmp;

/**
 * 暴力求解 字符串匹配问题
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str2 = "BBC ABCDAB ABCDABDABDE";
        String str1 = "DAB";
        int index = getIndex(str1, str2);
        System.out.println(index);
    }

    public static int getIndex(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        //匹配个数
        int count = 0;
        int str1Index = 0;
        int str2Index = 0;
        while (str1Index < length1 && str2Index < length2) {
            char char1 = chars1[str1Index];
            char char2 = chars2[str2Index];
            if (char1 == char2) {
                count++;
                str1Index++;
                str2Index++;
            } else {
                if (length1 >= length2) {
                    str1Index = str1Index - count + 1;
                    str2Index = 0;
                    count = 0;
                } else {
                    str1Index = 0;
                    str2Index = str2Index - count + 1;
                    count = 0;
                }
            }
        }
        if (count == 0) {
            return -1;
        }
        if (length1 >= length2) {
            return str1Index - count;
        } else {
            return str2Index - count;
        }
    }
}
