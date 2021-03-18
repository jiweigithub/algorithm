package com.shangguigu.datastructures.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 逆波兰表达式计算器
 */
public class ReversePolishCalculator {

    public static void main(String[] args) {
        ReversePolishCalculator calculator = new ReversePolishCalculator();
        String reversePolish = calculator.normal2ReversePolish("-3.0+(-1.0+1)*5");
        System.out.println(calculator.calculate(reversePolish));
    }

    public Double calculate(String input) {
        String[] inputString = input.split(" ");
        Deque<Double> nums = new LinkedList<>();
        for (int i = 0; i < inputString.length; i++) {
            if (inputString[i].matches("-?[0-9]+.*[0-9]*")) {
                nums.push(Double.parseDouble(inputString[i]));
            } else {
                Double num1 = nums.pop();
                Double num2 = nums.pop();
                Double result = execute(num2, num1, inputString[i]);
                nums.push(result);
            }
        }
        return nums.pop();
    }

    /**
     * 中缀表达式转逆波兰表达式
     *
     * @param input 中缀表达式
     * @return 逆波兰表达式
     */
    public String normal2ReversePolish(String input) {
        //0.定义运算符优先级表
        Map<String, Integer> opsMap = new HashMap<String, Integer>() {{
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
            put("%", 2);
            put("^", 3);
        }};
        //1.去除表达式中的空格
        input = input.replaceAll(" ", "");
        //2.定义两个栈 ops 运算符栈， mid 中间结果栈
        Deque<String> ops = new LinkedList<>();
        Deque<String> mid = new LinkedList<>();
        //3.将表达式转为字符数组
        char[] chars = input.toCharArray();
        //4.遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            String currentChar = String.valueOf(chars[i]);
            if (i == 0 && "+".equals(currentChar)) {
                i++;
                continue;
            }
            if (i == 0 && "-".equals(currentChar)) {
                i++;
                if (Character.isDigit(chars[i]) || chars[i] == '.') {
                    StringBuilder numBuilder = new StringBuilder("");
                    int j = i;
                    //从当前位置i开始，将后面的数字和.号连续取出拼接
                    while (j < chars.length && (Character.isDigit(chars[j]) || chars[j] == '.')) {
                        numBuilder.append(chars[j++]);
                    }
                    String numString = currentChar + numBuilder.toString();
                    //将数字结果压入mid栈
                    mid.push(numString);
                    i = j - 1;
                    continue;
                }
            }
            //5.如果遇到数字或者.号
            if (Character.isDigit(chars[i]) || chars[i] == '.') {
                StringBuilder numBuilder = new StringBuilder("");
                int j = i;
                //从当前位置i开始，将后面的数字和.号连续取出拼接
                while (j < chars.length && (Character.isDigit(chars[j]) || chars[j] == '.')) {
                    numBuilder.append(chars[j++]);
                }
                String numString = numBuilder.toString();
                //将数字结果压入mid栈
                mid.push(numString);
                i = j - 1;
                //6.如果遇到运算符
            } else if (opsMap.containsKey(currentChar)) {
                //a.如果ops栈为空,直接将其压入ops栈
                if (ops.isEmpty()) {
                    ops.push(currentChar);
                    //或者ops栈顶元素等于左括号,直接将其压入ops栈
                } else if ("(".equals(ops.peek())) {
                    ops.push(currentChar);
                } else {
                    //c.否则将ops栈顶运算符弹出，并压入到mid栈,再次比较当前运算符与ops新的栈顶运算符的优先级
                    while (!ops.isEmpty() && opsMap.get(currentChar) - opsMap.get(ops.peek()) <= 0) {
                        String pop = ops.pop();
                        mid.push(pop);
                    }
                    //b.如果当前运算符的优先级大于栈顶运算符的优先级，则将其压入ops栈
                    ops.push(currentChar);
                }
                //7.如果遇到括号
            } else if ("(".equals(currentChar)) {
                //a.如果是左括号，直接压入ops栈
                ops.push(currentChar);
                int next = i + 1;
                char nextChar = chars[next];
                //正负号处理
                if ("+".equals(String.valueOf(nextChar))) {
                    i = next;
                }
                if ("-".equals(String.valueOf(nextChar))) {
                    next++;
                    if (Character.isDigit(chars[next]) || chars[next] == '.') {
                        StringBuilder numBuilder = new StringBuilder("");
                        int j = next;
                        //从当前位置i开始，将后面的数字和.号连续取出拼接
                        while (j < chars.length && (Character.isDigit(chars[j]) || chars[j] == '.')) {
                            numBuilder.append(chars[j++]);
                        }
                        String numString = nextChar + numBuilder.toString();
                        //将数字结果压入mid栈
                        mid.push(numString);
                        i = j - 1;
                    }
                }
            } else if (")".equals(currentChar)) {
                //b.如果是右括号,则依次弹出ops栈顶运算符，并压入mid栈，直到遇到左括号为止，此时将这一对括号丢弃
                while (!"(".equals(ops.peek())) {
                    String pop = ops.pop();
                    mid.push(pop);
                }
                //弹出左括号
                ops.pop();
            }
        }
        //8.依次将ops栈中的运算符弹出并压入mid栈
        while (!ops.isEmpty()) {
            String pop = ops.pop();
            mid.push(pop);
        }
        //9.依次弹出mid栈中的元素并拼接，其结果的逆序即为中缀表达式对应的逆波兰表达式
        Deque<String> reversePolishStack = new LinkedList<>();

        while (!mid.isEmpty()) {
            reversePolishStack.push(mid.pop());
        }

        StringBuilder reversePolishBuilder = new StringBuilder("");
        do {
            if (reversePolishBuilder.length() == 0) {
                reversePolishBuilder.append(reversePolishStack.pop());
            } else {
                reversePolishBuilder.append(" ");
                reversePolishBuilder.append(reversePolishStack.pop());
            }
        } while (!reversePolishStack.isEmpty());
        return reversePolishBuilder.toString();
    }

    public Double execute(Double x, Double y, String c) {
        double result = 0;
        switch (c) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            default:
                break;
        }
        return result;
    }
}
