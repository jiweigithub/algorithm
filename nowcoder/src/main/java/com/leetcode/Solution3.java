package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 无重复字符的最长子串
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.lengthOfLongestSubstring("ab");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Integer> subStringLengthSet = new TreeSet<>();
        int start = 0;
        int end = 1;
        while (end <= s.length() - 1) {
            String substring = s.substring(start, end);
            char c1 = s.charAt(end);
            if (substring.contains(String.valueOf(c1))) {
                subStringLengthSet.add(substring.length());
                start++;
                end = start + 1;
            } else {
                if (end == s.length() - 1) {
                    String substring1 = s.substring(start);
                    subStringLengthSet.add(substring1.length());
                }
                end++;
            }
        }
        List<Integer> collect = new ArrayList<>(subStringLengthSet);
        return collect.get(collect.size() - 1);
    }

}
