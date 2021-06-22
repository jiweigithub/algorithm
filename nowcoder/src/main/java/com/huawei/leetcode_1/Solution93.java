package com.huawei.leetcode_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * <p>
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class Solution93 {

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    List<String> segments = new ArrayList<>();

    public static void main(String[] args) {
        String input = "25525511135";
        Solution93 solution93 = new Solution93();
        solution93.restoreIpAddresses(input);
    }

    public List<String> restoreIpAddresses(String s) {
        solution(s, 0, 0);
        System.out.println(ans);
        return ans;
    }

    public void solution(String s, int segStart, int segId) {
        //如果片段满四段且耗尽所有字符,说明找到一种结果
        if (segments.size() == SEG_COUNT && segStart == s.length()) {
            ans.add(String.join(".", segments));
            return;
        }
        //满四段但是字符未耗尽，说明无法找到答案，提前返回
        if (segments.size() == SEG_COUNT && segStart < s.length()) {
            return;
        }
        for (int len = 1; len <= 3; len++) {
            //如果起始位置加上要切分的长度越界，说明已经无法切分，返回
            if (segStart + len - 1 >= s.length()) {
                return;
            }
            //如果长度不为1，但是切分后的第一个字符为0，直接返回
            if (len != 1 && s.charAt(segStart) == '0') {
                return;
            }
            //进行切分
            String part = s.substring(segStart, segStart + len);
            int i = Integer.parseInt(part);
            //如果切分长度为3且切分结果大于255，直接返回
            if (len == 3 && i > 255) {
                return;
            }
            //做出选择
            segments.add(segId, part);
            //基于当前选择，进行下一步切分
            solution(s, segStart + len, segId + 1);
            //回溯，撤销最后选择
            segments.remove(segId);
        }
    }

}
