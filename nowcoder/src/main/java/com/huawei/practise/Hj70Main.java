package com.huawei.practise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 矩阵乘法计算量估算
 * <p>
 * 题目描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 * <p>
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * <p>
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 * <p>
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 * <p>
 * 本题含有多组样例输入！
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 * <p>
 * 输出描述:
 * 输出需要进行的乘法次数
 * <p>
 * 示例1
 * 输入
 * 3
 * 50 10
 * 10 20
 * 20 5
 * (A(BC))
 * 输出
 * 3500
 */
public class Hj70Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int count = Integer.parseInt(scanner.nextLine());
            int[][] arrays = new int[count][2];
            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine();
                String[] s = line.split(" ");
                for (int j = 0; j < s.length; j++) {
                    arrays[i][j] = Integer.parseInt(s[j]);
                }
            }
            String express = scanner.nextLine();
            solution(arrays, express);
        }
    }

    public static void solution(int[][] arrays, String express) {
        char[] chars = express.toCharArray();
        int index = 0;
        int count = 0;
        Deque<Matrix> stack = new LinkedList<>();
        Deque<Character> operStack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                operStack.push(chars[i]);
            } else if (Character.isLetter(chars[i])) {
                Matrix matrix = new Matrix(chars[i], index, arrays[index][0], arrays[index][1]);
                stack.push(matrix);
                index++;
            } else {
                Matrix matrix1 = !stack.isEmpty() ? stack.pop() : null;
                Matrix matrix2 = !stack.isEmpty() ? stack.pop() : null;
                if (matrix1 != null && matrix2 != null) {
                    Matrix newMatrix = new Matrix('X', -1, matrix2.x, matrix1.y);
                    count += matrix2.x * matrix1.x * matrix1.y;
                    stack.push(newMatrix);
                }
                if (!operStack.isEmpty()) {
                    operStack.pop();
                }

            }
        }
        System.out.println(count);
    }
}

class Matrix {

    char c;

    int index;

    int x;

    int y;

    public Matrix(char c, int index, int x, int y) {
        this.c = c;
        this.index = index;
        this.x = x;
        this.y = y;
    }
}
