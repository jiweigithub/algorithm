package com.huawei.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数组分组
 * 题目描述
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，
 * 所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，输出true；不满足时输出false。
 * 本题含有多组样例输入。
 * 输入描述:
 * 第一行是数据个数，第二行是输入的数据
 * <p>
 * 输出描述:
 * 返回true或者false
 * <p>
 * 示例1
 * 输入
 * 复制
 * 4
 * 1 5 -5 1
 * 3
 * 3 5 8
 * 输出
 * 复制
 * true
 * 说明
 * 第一个样例：
 * 第一组：5 -5 1
 * 第二组：1
 * 第二个样例：由于3和5不能放在同一组，所以不存在一种分法。
 */
public class Hj93Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            List<Integer> nums = new ArrayList<>();
            int threeSum = 0;
            int fiveSum = 0;
            int sum = 0;
            for (int i = 0; i < count; i++) {
                int num = scanner.nextInt();
                if (Math.abs(num) % 3 == 0) {
                    threeSum += num;
                } else if (Math.abs(num) % 5 == 0) {
                    fiveSum += num;
                } else {
                    nums.add(num);
                }
                sum += num;
            }
            //能否分组
            int required = sum / 2 - threeSum;
            if (sum % 2 != 0) {
                System.out.println(false);
            } else {
                System.out.println(solution(nums, required));
            }
        }
    }

    public static boolean solution(List<Integer> nums, int required) {
        return solution(0, nums, required);
    }

    public static boolean solution(int index, List<Integer> nums, int required) {
        if (index == nums.size()) {
            return required == 0;
        }
        return solution(index + 1, nums, required - nums.get(index)) || solution(index + 1, nums, required);
    }

}
