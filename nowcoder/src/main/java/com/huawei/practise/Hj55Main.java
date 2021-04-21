package com.huawei.practise;

import java.util.Scanner;

/**
 * 挑7
 * <p>
 * 题目描述
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 * <p>
 * 输入描述:
 * 一个正整数N。(N不大于30000)
 * <p>
 * 输出描述:
 * 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 * <p>
 * 示例1
 * 输入
 * 20
 * 10
 * 输出
 * 3
 * 1
 */
public class Hj55Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int count = 0;
            while (num > 0) {
                if (hasSeven(num, false)) {
                    count++;
                }
                num--;
            }
            System.out.println(count);
        }
    }

    public static boolean hasSeven(int num, boolean flag) {
        if (num > 0) {
            //个位为7
            if (num % 10 == 7) {
                return true;
            }
            //7的倍数
            if (num % 7 == 0 && !flag) {
                return true;
            }
            num = num / 10;
            return hasSeven(num, true);
        } else {
            return false;
        }
    }

}
