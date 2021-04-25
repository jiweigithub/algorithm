package com.huawei.practise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 参数解析
 * <p>
 * 在命令行输入如下命令：
 * <p>
 * xcopy /s c:\ d:\，
 * <p>
 * 各个参数如下：
 * <p>
 * 参数1：命令字xcopy
 * <p>
 * 参数2：字符串/s
 * <p>
 * 参数3：字符串c:\
 * <p>
 * 参数4: 字符串d:\
 * <p>
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 * <p>
 * <p>
 * 解析规则：
 * <p>
 * 1.参数分隔符为空格
 * 2.对于用""包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\program files" "d:\"时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将""去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 * <p>
 * <p>
 * 输入描述:
 * 输入一行字符串，可以有空格
 * <p>
 * 输出描述:
 * 输出参数个数，分解后的参数，每个参数都独占一行
 * <p>
 * 示例1
 * 输入
 * xcopy /s c:\\ d:\\
 * 输出
 * 4
 * xcopy
 * /s
 * c:\\
 * d:\\
 */
public class Hj74Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            solution(scanner.nextLine());
        }
    }

    private static void solution(String input) {
        char[] chars = input.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (char c : chars) {
            if (c == ' ' && stack.isEmpty()) {
                result.append("\n");
                count++;
                continue;
            }
            if (c == ' ' && !stack.isEmpty()) {
                result.append(c);
                continue;
            }
            if (c == '\"' && stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            if (c == '\"' && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            if (c != ' ') {
                result.append(c);
            }
        }
        System.out.println(count + 1);
        System.out.print(result.toString());
    }
}
