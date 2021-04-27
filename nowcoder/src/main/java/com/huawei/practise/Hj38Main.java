package com.huawei.practise;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 求小球落地5次后所经历的路程和第5次反弹的高度
 * <p>
 * 题目描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * <p>
 * 最后的误差判断是小数点6位
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入起始高度，int型
 * <p>
 * 输出描述:
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 * <p>
 * 示例1
 * 输入
 * 1
 * 输出
 * 2.875
 * 0.03125
 */
public class Hj38Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int i = sc.nextInt();
            BigDecimal sum = new BigDecimal(0);
            BigDecimal high = new BigDecimal(i);
            solution(sum, high, 4);
        }
    }

    /**
     *
     * @param sum 最终距离
     * @param h   初始高度
     * @param num 反弹次数
     */
    public static void solution(BigDecimal sum, BigDecimal h, int num) {
        if (num >= 0 && h.compareTo(new BigDecimal(0)) > 0) {
            //落地一次
            sum = sum.add(h);
            BigDecimal divide = h.divide(new BigDecimal(2));
            if (num > 0) {
                //反弹一次
                sum = sum.add(divide);
            }
            num--;
            solution(sum, divide, num);
        } else {
            System.out.println(sum.stripTrailingZeros().toString());
            System.out.println(h.stripTrailingZeros().toString());
        }
    }
}
