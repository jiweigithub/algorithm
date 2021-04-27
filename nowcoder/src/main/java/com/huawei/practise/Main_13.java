package com.huawei.practise;

import java.util.Scanner;

/**
 * 句子逆序
 */
public class Main_13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputWordArray = input.split(" ");
        for (int i = inputWordArray.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(inputWordArray[i]);
            } else {
                System.out.print(inputWordArray[i] + " ");
            }
        }
    }
}
