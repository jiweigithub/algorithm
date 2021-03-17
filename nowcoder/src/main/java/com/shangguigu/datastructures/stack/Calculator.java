package com.shangguigu.datastructures.stack;

import java.util.*;

/**
 * 使用栈来模拟计算器
 */
public class Calculator {

    /**
     * 优先级表
     */
    Map<Character, Integer> priorityMap = new HashMap<Character, Integer>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean loop = true;
        while (loop) {
            System.out.println("请输入要计算的表达式");
            String input = scanner.nextLine();
            int calculate = calculator.calculate(input);
            System.out.println("计算的结果为：" + calculate);
        }
    }

    public int calculate(String input) {
        // 将所有的空格去掉，并将 (- 替换为 (0-
        input = input.replaceAll(" ", "");
        input = input.replaceAll("\\(-", "(0-");
        //创建符号栈
        Deque<Character> operStack = new LinkedList<>();
        //创建数字栈
        Deque<Integer> numStack = new LinkedList<>();
        //防止第一个数为负数，提前向数字栈中放入一个0
        numStack.push(0);
        char[] chars = input.toCharArray();
        //遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            //如果是前括号，直接放入符号栈
            if (aChar == '(') {
                operStack.push(aChar);
            } else if (aChar == ')') {
                //当操作符号栈不为空时
                while (!operStack.isEmpty()) {
                    //获取栈顶的操作符
                    Character peek = operStack.peek();
                    //如果栈顶操作符不等于(
                    if (peek != '(') {
                        //进行计算
                        calc(numStack, operStack);
                    } else {
                        operStack.pop();
                        break;
                    }
                }
            } else {
                //如果是数字
                if (Character.isDigit(aChar)) {
                    int num = 0;
                    int j = i;
                    //从当前位置i开始，将后面的数字连续取出
                    while (j < chars.length && Character.isDigit(chars[j])) {
                        num = num * 10 + (chars[j++] - '0');
                    }
                    numStack.push(num);
                    i = j - 1;
                } else {
                    while (!operStack.isEmpty() && operStack.peek() != '(') {
                        Character pre = operStack.peek();
                        //如果栈顶的操作符优先级大于等于当前操作符优先级
                        if (priorityMap.get(pre) >= priorityMap.get(aChar)) {
                            calc(numStack, operStack);
                        } else {
                            break;
                        }
                    }
                    operStack.push(aChar);
                }
            }

        }
        while (!operStack.isEmpty() && operStack.peek() != '(') {
            calc(numStack, operStack);
        }
        return numStack.peek();
    }

    private void calc(Deque<Integer> numStack, Deque<Character> operStack) {
        if (numStack.isEmpty() || numStack.size() < 2) {
            return;
        }
        if (operStack.isEmpty()) {
            return;
        }
        Integer num1 = numStack.pop();
        Integer num2 = numStack.pop();
        Character oper = operStack.pop();
        int result = execute(num2, num1, oper);
        numStack.push(result);
    }

    public static int execute(int x, int y, char c) {
        int result = 0;
        switch (c) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
            default:
                break;
        }
        return result;
    }

}
