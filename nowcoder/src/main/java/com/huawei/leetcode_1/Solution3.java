package com.huawei.leetcode_1;

import java.util.*;

/**
 * 无重复字符的最长子串
 */
public class Solution3 {

    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring3("abba");
        System.out.println(ans);
    }

    /**
     * 双指针求解
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Set<Integer> lengthSet = new TreeSet<>();
        int start = 0;
        int end = 1;
        while (end < s.length()) {
            String substring = s.substring(start, end);
            char endChar = s.charAt(end);
            //如果子串中包含endChar，说明有重复
            if (substring.indexOf(endChar) > -1) {
                lengthSet.add(substring.length());
                start++;
                end = start + 1;
            } else {
                if (end == s.length() - 1) {
                    String substring1 = s.substring(start);
                    lengthSet.add(substring1.length());
                }
                end++;
            }
        }
        List<Integer> collect = new ArrayList<>(lengthSet);
        return collect.get(collect.size() - 1);
    }

    /**
     * 滑动窗口求解
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int n = s.length(), ans = 0;
        //窗口左边界
        int start = 0;
        //窗口右边界
        int end = 1;
        while (start < n && end < n) {
            String substring = s.substring(start, end);
            char endChar = s.charAt(end);
            if (substring.indexOf(endChar) > -1) {
                ans = Math.max(substring.length(), ans);
                start++;
            } else {
                if (end == s.length() - 1) {
                    String substring2 = s.substring(start);
                    ans = Math.max(substring2.length(), ans);
                }
                end++;
            }
        }
        return ans;
    }

    /**
     * 滑动窗口求解优化版
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        //定义一个字符位置map key为字符，val为字符坐标的下一个坐标
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            //如果map的key中有该字符，说明该字符已经出现过了
            if (map.containsKey(alpha)) {
                //从map中获取start上次出现位置的下一个位置，比较其与当前start的大小，取较大值
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }


}
