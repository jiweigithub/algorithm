package com.huawei.practise;

import java.util.Scanner;

/**
 * 求连续最大bit数
 */
public class Hj86Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            String binaryString = Integer.toBinaryString(input);
            int countOne = countOne(binaryString.toCharArray());
            System.out.println(countOne);
        }
    }

    public static int countOne(char[] chars) {
        int maxCount = 0;
        int tempCount = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == '1') {
                tempCount++;
                maxCount = Math.max(maxCount, tempCount);
                i++;
            } else {
                tempCount = 0;
                i++;
            }
        }
        return maxCount;
    }

}
