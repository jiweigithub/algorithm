package com.huawei.practise;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 在字符串中找出最长连续数字串
 */
public class Hj92Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            List<String> beginList = new ArrayList<>();
            int longestNumStr = getLongestNumStr(input, beginList);
            List<String> collect = beginList.stream().filter(item -> item.length() == longestNumStr).collect(Collectors.toList());
            StringBuilder result = new StringBuilder();
            for (String s : collect) {
                result.append(s);
            }
            System.out.println(result.toString() + "," + longestNumStr);
        }
    }

    public static int getLongestNumStr(String input, List<String> beginList) {
        int maxCount = 0;
        int tempCount = 0;
        int i = 0;
        int begin = 0;
        while (i < input.length()) {
            if (Character.isDigit(input.charAt(i))) {
                tempCount++;
                if (maxCount <= tempCount) {
                    maxCount = tempCount;
                    begin = i - maxCount + 1;
                    beginList.add(input.substring(begin, begin + maxCount));
                }
            } else {
                tempCount = 0;
            }
            i++;
        }
        return maxCount;
    }
}
