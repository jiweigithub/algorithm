package com.huawei.practise;

import java.util.Scanner;

/**
 * 计算整数的二进制中1的个数
 */
public class Hj62Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            long input = Long.parseLong(scanner.nextLine());
            String binaryString = Long.toBinaryString(input);
            int count = 0;
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
