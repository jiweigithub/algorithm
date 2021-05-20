package com.huawei.practise;

import java.util.*;

/**
 * 字符统计
 *
 * 题目描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 本题含有多组样例输入
 * <p>
 * 输入描述:
 * 一个只包含小写英文字母和数字的字符串。
 * <p>
 * 输出描述:
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 * <p>
 * 示例1
 * 输入
 * aaddccdc
 * 1b1bbbbbbbbb
 * 输出
 * cda
 * b1
 * 说明
 * 第一个样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
 */
public class Hj102Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            char[] chars = input.toCharArray();
            Map<Character, Integer> charMap = new HashMap<>(16);
            for (char aChar : chars) {
                if (charMap.containsKey(aChar)) {
                    charMap.put(aChar, charMap.get(aChar) + 1);
                } else {
                    charMap.put(aChar, 1);
                }
            }
            Set<Map.Entry<Character, Integer>> entries = charMap.entrySet();
            ArrayList<Map.Entry<Character, Integer>> entryArrayList = new ArrayList<>(entries);
            entryArrayList.sort((o1, o2) -> {
                if (o2.getValue() - o1.getValue() == 0) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return o2.getValue() - o1.getValue();
                }
            });
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : entryArrayList) {
                sb.append(entry.getKey());
            }
            System.out.println(sb.toString());
        }
    }
}

