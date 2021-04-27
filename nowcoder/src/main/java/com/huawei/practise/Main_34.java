package com.huawei.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符排序
 */
public class Main_34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            char[] chars = input.toCharArray();
            List<Character> characterList = new ArrayList<>();
            for (char c : chars) {
                characterList.add(c);
            }
            characterList.sort(Character::compareTo);
            StringBuilder builder = new StringBuilder();
            characterList.forEach(character -> {
                builder.append(character.charValue());
            });
            System.out.println(builder.toString());
        }
    }
}
