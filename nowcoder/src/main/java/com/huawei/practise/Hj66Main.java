package com.huawei.practise;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 命令匹配
 * <p>
 * 题目描述
 * 有6条配置命令，它们执行的结果分别是：
 * <p>
 * 命   令	            执   行
 * reset	            reset what
 * reset board	        board fault
 * board add	        where to add
 * board delete	        no board at all
 * reboot backplane	    impossible
 * backplane abort	    install first
 * he he	            unknown command
 * 注意：he he不是命令。
 * <p>
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
 * <p>
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 * <p>
 * <p>
 * 输入描述:
 * 多行字符串，每行字符串一条命令
 * <p>
 * 输出描述:
 * 执行结果，每条命令输出一行
 * <p>
 * 示例1
 * 输入
 * 复制
 * reset
 * reset board
 * board add
 * board delet
 * reboot backplane
 * backplane abort
 * <p>
 * 输出
 * 复制
 * reset what
 * board fault
 * where to add
 * no board at all
 * impossible
 * install first
 */
public class Hj66Main {

    static Map<String, String> instructionMap = new HashMap<>();



    public static void main(String[] args) {
        {
            instructionMap.put("reset", "reset what");
            instructionMap.put("reset board", "board fault");
            instructionMap.put("board add", "where to add");
            instructionMap.put("board delete", "no board at all");
            instructionMap.put("reboot backplane", "impossible");
            instructionMap.put("backplane abort", "install first");
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            executeInstruction(line.trim());
        }
    }

    public static void executeInstruction(String instruction) {
        if(instruction.length()<1) {
            return;
        }
        String[] inses = instruction.split(" ");
        if (inses.length > 1) {
            String ins1 = inses[0];
            String ins2 = inses[1];
            //先匹配第一个字串
            Set<String> firstMatchKey = matchFirstInstruction(ins1);
            if (firstMatchKey.size() < 1) {
                System.out.println("unknown command");
                return;
            }
            Set<String> secondMatchKey = matchSecondInstruction(firstMatchKey, ins2);
            if(secondMatchKey.size() == 1) {
                String next = secondMatchKey.iterator().next();
                System.out.println(instructionMap.get(next));
            } else {
                System.out.println("unknown command");
            }

        } else {
            String ins1 = inses[0];
            Set<String> keySet = matchFirstInstruction(ins1);
            if (keySet.size() < 1) {
                System.out.println("unknown command");
                return;
            }
            List<String> sorted = keySet.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
            String key = sorted.get(0);
            String[] split = key.split(" ");
            if (split.length > 1) {
                System.out.println("unknown command");
            } else {
                System.out.println(instructionMap.get(key));
            }
        }
    }

    public static Set<String> matchFirstInstruction(String input) {
        Set<String> matchKey = new HashSet<>();
        //只匹配第一个字串
        Set<String> keys = instructionMap.keySet();
        for (String key : keys) {
            String[] keySplit = key.split(" ");
            String part1 = keySplit[0];
            if (part1.startsWith(input)) {
                matchKey.add(key);
            }
        }
        return matchKey;
    }

    public static Set<String> matchSecondInstruction(Set<String> firstMatchSet, String tow) {
        Set<String> matchKey = new HashSet<>();
        //在第一个字串匹配的基础上，匹配第二个字串
        for (String key : firstMatchSet) {
            String[] keySplit = key.split(" ");
            if (keySplit.length > 1) {
                String part2 = keySplit[1];
                if (part2.startsWith(tow)) {
                    matchKey.add(key);
                }
            }
        }
        return matchKey;
    }
}
