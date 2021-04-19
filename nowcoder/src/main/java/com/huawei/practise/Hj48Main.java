package com.huawei.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 信号测量的结果包括测量编号和测量值。存在信号测量结果丢弃及测量结果重复的情况。
 * <p>
 * <p>
 * 1.测量编号不连续的情况，认为是测量结果丢弃。对应测量结果丢弃的情况，需要进行插值操作以更准确的评估信号。
 * <p>
 * 采用简化的一阶插值方法,由丢失的测量结果两头的测量值算出两者中间的丢失值。
 * <p>
 * 假设第M个测量结果的测量值为A，第N个测量结果的测量值为B。则需要进行(N-M-1)个测量结果的插值处理。进行一阶线性插值估计的第N+i个测量结果的测量值为A+( (B-A)/(N-M) )*i  (注：N的编号比M大。)
 * <p>
 * 例如：只有测量编号为4的测量结果和测量编号为7的测量结果，测量值分别为4和10
 * <p>
 * 则需要补充测量编号为5和6的测量结果。
 * <p>
 * 其中测量编号为5的测量值=4 + ((10-4)/(7-4))*1 = 6
 * <p>
 * 其中测量编号为6的测量值=4 + ((10-4)/(7-4))*2 = 8
 * <p>
 * <p>
 * 2.测量编号相同，则认为测量结果重复，需要对丢弃后来出现的测量结果。
 * <p>
 * <p>
 * 请根据以上规则进行测量结果的整理。
 * <p>
 * <p>
 * 输入描述:
 * 输入说明
 * 1 输入两个整数m, n
 * 2 输入m个数据组
 * <p>
 * 输出描述:
 * 输出整理后的结果
 * <p>
 * 示例1
 * 输入
 * 复制
 * 2 3
 * 4 5 第一个数据  2 为编号 5 为对应的值
 * 5 7 第二个数据  5 为编号 7 为对应的值
 * 输出
 * 复制
 * 4 5
 * 5 7
 */
public class Hj48Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int inputCount = Integer.parseInt(split[0]);
            List<Input> inputs = new ArrayList<>();
            String line1 = scanner.nextLine();
            String[] s = line1.split(" ");
            int num = Integer.parseInt(s[0]);
            int val = Integer.parseInt(s[1]);
            inputs.add(new Input(num, val));
            for (int i = 1; i < inputCount; i++) {
                String line2 = scanner.nextLine();
                s = line2.split(" ");
                num = Integer.parseInt(s[0]);
                val = Integer.parseInt(s[1]);
                Input pre = inputs.get(i - 1);
                //如果前一个和
                if (pre.num == num) {
                    continue;
                }
                if (pre.val + 1 < val && num > pre.num) {
                    int dif = val - pre.val;
                    for (int k = 1; k <= dif; k++) {
                        int newNum = pre.num + k;
                        int newVal = pre.val + (val - pre.val) / (num - pre.num) * k;
                        Input difInput = new Input(newNum, newVal);
                        inputs.add(difInput);
                    }
                }
            }
        }

    }
}

class Input {

    int num;

    int val;

    public Input(int num, int val) {
        this.num = num;
        this.val = val;
    }
}
