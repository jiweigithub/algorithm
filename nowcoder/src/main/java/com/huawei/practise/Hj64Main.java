package com.huawei.practise;

import java.util.Scanner;

/**
 * MP3光标
 * <p>
 * 题目描述
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。
 * 为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 * <p>
 * <p>
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 * <p>
 * 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 * <p>
 * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 * 其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。
 * <p>
 * 歌曲总数大于4的时候（以一共有10首歌为例）：
 * <p>
 * 特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，
 * 屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。
 * 同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。
 * <p>
 * <p>
 * 一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，
 * 屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。光标当前屏幕的最后一首歌时的Down键处理也类似。
 */
public class Hj64Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int count = Integer.parseInt(scanner.nextLine());
            String oper = scanner.nextLine();
            int[] arr = new int[count];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
            char[] chars = oper.toCharArray();
            int length = arr.length;
            int current = 0;
            if (length <= 4) {
                for (char c : chars) {
                    if (c == 'U') {
                        if (current == 0) {
                            current = length - 1;
                        } else {
                            current--;
                        }
                    }
                    if (c == 'D') {
                        if (current == length - 1) {
                            current = 0;
                        } else {
                            current++;
                        }
                    }
                }
                StringBuilder result = new StringBuilder();
                for (int i : arr) {
                    result.append(i).append(" ");
                }
                System.out.println(result.toString());
                System.out.println(arr[current]);
            } else {
                int begin = 0;
                int end = 3;
                for (char c : chars) {
                    if (c == 'U') {
                        if (current == 0) {
                            current = length - 1;
                            begin = length - 4;
                            end = length - 1;
                        } else {
                            if (current == begin) {
                                begin--;
                                end--;
                            }
                            current--;
                        }
                    }
                    if (c == 'D') {
                        if (current == length - 1) {
                            current = 0;
                            begin = 0;
                            end = 3;
                        } else {
                            if (current == end) {
                                begin++;
                                end++;
                            }
                            current++;
                        }
                    }
                }
                StringBuilder result = new StringBuilder();
                for (int i = begin; i <= end; i++) {
                    result.append(arr[i]).append(" ");
                }
                System.out.println(result.toString());
                System.out.println(arr[current]);
            }
        }
    }
}
