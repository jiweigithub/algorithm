package com.huawei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉诺塔
 */
public class HanoiTower {

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        hanoiTower.hanota(A, B, C);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    public void move(int num, List<Integer> current, List<Integer> mid, List<Integer> target) {
        // 只剩一个盘子时，直接移动即可
        if (num == 1) {
            target.add(current.remove(current.size() - 1));
        } else {
            // 将 size-1 个盘子，从 current 移动到 mid
            move(num - 1, current, target, mid);
            // 将 第size个盘子，从 original 移动到 target
            target.add(current.remove(current.size() - 1));
            // 将 size-1 个盘子，从 auxiliary 移动到 target
            move(num - 1, mid, current, target);
        }
    }
}
