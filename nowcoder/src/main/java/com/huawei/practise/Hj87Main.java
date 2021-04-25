package com.huawei.practise;

import java.util.Scanner;

/**
 * 密码强度等级
 * 题目描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 * <p>
 * 一、密码长度:
 * <p>
 * 5 分: 小于等于4 个字符
 * <p>
 * 10 分: 5 到7 字符
 * <p>
 * 25 分: 大于等于8 个字符
 * <p>
 * 二、字母:
 * <p>
 * 0 分: 没有字母
 * <p>
 * 10 分: 全都是小（大）写字母
 * <p>
 * 20 分: 大小写混合字母
 * <p>
 * 三、数字:
 * <p>
 * 0 分: 没有数字
 * <p>
 * 10 分: 1 个数字
 * <p>
 * 20 分: 大于1 个数字
 * <p>
 * 四、符号:
 * <p>
 * 0 分: 没有符号
 * <p>
 * 10 分: 1 个符号
 * <p>
 * 25 分: 大于1 个符号
 * <p>
 * 五、奖励:
 * <p>
 * 2 分: 字母和数字
 * <p>
 * 3 分: 字母、数字和符号
 * <p>
 * 5 分: 大小写字母、数字和符号
 * <p>
 * 最后的评分标准:
 * <p>
 * >= 90: 非常安全
 * <p>
 * >= 80: 安全（Secure）
 * <p>
 * >= 70: 非常强
 * <p>
 * >= 60: 强（Strong）
 * <p>
 * >= 50: 一般（Average）
 * <p>
 * >= 25: 弱（Weak）
 * <p>
 * >= 0:  非常弱
 * <p>
 * <p>
 * 对应输出为：
 * <p>
 * VERY_SECURE
 * <p>
 * SECURE,
 * <p>
 * VERY_STRONG,
 * <p>
 * STRONG,
 * <p>
 * AVERAGE,
 * <p>
 * WEAK,
 * <p>
 * VERY_WEAK,
 * <p>
 * <p>
 * 请根据输入的密码字符串，进行安全评定。
 * <p>
 * 注：
 * <p>
 * 字母：a-z, A-Z
 * <p>
 * 数字：-9
 * <p>
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * <p>
 * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
 * <p>
 * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
 * <p>
 * [\]^_`              (ASCII码：x5B~0x60)
 * <p>
 * {|}~                (ASCII码：x7B~0x7E)
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 本题含有多组输入样例。
 * 每组样例输入一个string的密码
 * <p>
 * 输出描述:
 * 每组样例输出密码等级
 * <p>
 * 示例1
 * 输入
 * 复制
 * 38$@NoNoNo
 * 123
 * 输出
 * 复制
 * VERY_SECURE
 * WEAK
 * 说明
 * 第一组样例密码强度为95分。
 * 第二组样例密码强度为25分。
 */
public class Hj87Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            int grad = grad(input);
            print(grad);
        }
    }

    /**
     * * 一、密码长度:
     * * 5 分: 小于等于4 个字符
     * * 10 分: 5 到7 字符
     * * 25 分: 大于等于8 个字符
     * * 二、字母:
     * * 0 分: 没有字母
     * * 10 分: 全都是小（大）写字母
     * * 20 分: 大小写混合字母
     * * 三、数字:
     * * 0 分: 没有数字
     * * 10 分: 1 个数字
     * * 20 分: 大于1 个数字
     * * 四、符号:
     * * 0 分: 没有符号
     * * 10 分: 1 个符号
     * * 25 分: 大于1 个符号
     * * 五、奖励:
     * * 2 分: 字母和数字
     * * 3 分: 字母、数字和符号
     * * 5 分: 大小写字母、数字和符号
     * * 最后的评分标准:
     *
     * @param input
     * @return
     */
    public static int grad(String input) {
        int grad = 0;
        //判断密码长度
        if (input.length() <= 4) {
            grad += 5;
        } else if (input.length() <= 7) {
            grad += 10;
        } else {
            grad += 25;
        }
        //判断字母 数字 符号
        char[] chars = input.toCharArray();
        int upperCount = 0;
        int lowerCount = 0;
        int numCount = 0;
        int opCount = 0;
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            } else if (Character.isDigit(c)) {
                numCount++;
            } else if (Character.isWhitespace(c)) {
                continue;
            } else {
                opCount++;
            }
        }
        //判断字母
        if ((upperCount > 0 && lowerCount == 0) || (upperCount == 0 && lowerCount > 0)) {
            grad += 10;
        } else if (upperCount > 0 && lowerCount > 0) {
            grad += 20;
        }
        //判断数字
        if (numCount == 1) {
            grad += 10;
        } else if (numCount > 1) {
            grad += 20;
        }
        //判断符号
        if (opCount == 1) {
            grad += 10;
        } else if (opCount > 1) {
            grad += 25;
        }

        //奖励分数
        if (numCount > 0 && lowerCount > 0 && upperCount > 0 && opCount > 0) {
            grad += 5;
        } else if (numCount > 0 && lowerCount + upperCount > 0 && opCount > 0) {
            grad += 3;
        } else if (numCount > 0 && lowerCount + upperCount > 0) {
            grad += 2;
        }
        return grad;
    }

    /**
     * * >= 90: 非常安全
     * * <p>
     * * >= 80: 安全（Secure）
     * * <p>
     * * >= 70: 非常强
     * * <p>
     * * >= 60: 强（Strong）
     * * <p>
     * * >= 50: 一般（Average）
     * * <p>
     * * >= 25: 弱（Weak）
     * * <p>
     * * >= 0:  非常弱
     * <p>
     * * VERY_SECURE
     * * <p>
     * * SECURE,
     * * <p>
     * * VERY_STRONG,
     * * <p>
     * * STRONG,
     * * <p>
     * * AVERAGE,
     * * <p>
     * * WEAK,
     * * <p>
     * * VERY_WEAK,
     *
     * @param count
     */
    public static void print(int count) {
        if (count >= 90) {
            System.out.println("VERY_SECURE");
        } else if (count >= 80) {
            System.out.println("SECURE");
        } else if (count >= 70) {
            System.out.println("VERY_STRONG");
        } else if (count >= 60) {
            System.out.println("STRONG");
        } else if (count >= 50) {
            System.out.println("AVERAGE");
        } else if (count >= 25) {
            System.out.println("WEAK");
        } else {
            System.out.println("VERY_WEAK");
        }
    }

}
