package com.huawei.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * 人民币转换
 * <p>
 * 题目描述
 * 考试题目和要点：
 * <p>
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
 * <p>
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
 * <p>
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 * 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
 * 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 输入描述:
 * 输入一个double数
 * <p>
 * 输出描述:
 * 输出人民币格式
 * <p>
 * 示例1
 * 输入
 * 复制
 * 151121.15
 * 10012.02
 * 输出
 * 复制
 * 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 * 人民币壹万零拾贰元贰分
 */
public class Hj95Main {

    static Map<Integer, String> dict = new HashMap<>();

    public static void main(String[] args) {
        dict.put(1, "壹");
        dict.put(2, "貳");
        dict.put(3, "叁");
        dict.put(4, "肆");
        dict.put(5, "伍");
        dict.put(6, "陆");
        dict.put(7, "柒");
        dict.put(8, "捌");
        dict.put(9, "玖");
        dict.put(0, "零");
        dict.put(10, "拾");
        dict.put(100, "佰");
        dict.put(1000, "仟");
        dict.put(10000, "万");
        dict.put(100000000, "亿");
    }

    public static void print(String input) {
        String[] split = input.split("\\.");
        String z = split[0];
        String x = split[1];
        String temp = "0." + x;
        Double aDouble = Double.valueOf(temp);
        String tailFix = "";
        if (aDouble.compareTo((double) 0) == 0) {
            tailFix = "整";
        } else {
            int i = Integer.parseInt(x);

        }
    }

}
