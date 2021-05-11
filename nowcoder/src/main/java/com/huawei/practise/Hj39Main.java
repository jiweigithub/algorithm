package com.huawei.practise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 判断两个IP是否属于同一子网
 * <p>
 * 题目描述
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。
 * 利用子网掩码可以判断两台主机是否中同一子网中。
 * 若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 * <p>
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 * <p>
 * 转化为二进制进行运算：
 * <p>
 * I P 地址　11010000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 * <p>
 * AND运算
 * 11000000.10101000.00000000.00000000
 * <p>
 * 转化为十进制后为：
 * 192.168.0.0
 * <p>
 * <p>
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 * <p>
 * <p>
 * 转化为二进制进行运算：
 * <p>
 * I P 地址　11010000.10101000.00000000.11111110
 * 子网掩码　11111111.11111111.11111111.00000000
 * <p>
 * AND运算
 * 11000000.10101000.00000000.00000000
 * <p>
 * 转化为十进制后为：
 * 192.168.0.0
 * <p>
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 * <p>
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
 * <p>
 * <p>
 * 输入描述:
 * 输入子网掩码、两个ip地址
 * <p>
 * 输出描述:
 * 得到计算结果
 * <p>
 * 示例1
 * 输入
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 输出
 * 1
 * 2
 */
public class Hj39Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String mask = sc.nextLine();
            String ip1 = sc.nextLine();
            String ip2 = sc.nextLine();
            solution(mask, ip1, ip2);
        }
    }

    public static void solution(String maskIp, String ip1, String ip2) {
        boolean b = isErrorMask(maskIp);
        boolean b1 = ipRight(ip1);
        boolean b2 = ipRight(ip2);
        if (!b && b1 && b2) {
            String[] maskSplit = maskIp.split("\\.");
            String[] ip1Split = ip1.split("\\.");
            String[] ip2Split = ip2.split("\\.");
            String result1 = and(maskSplit, ip1Split);
            String result2 = and(maskSplit, ip2Split);
            if (result1.equals(result2)) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        } else {
            System.out.println(1);
        }
    }

    private static String and(String[] maskSplit, String[] ip1Split) {
        StringBuilder res = new StringBuilder();
        List<String> maskList = Arrays.asList(maskSplit);
        List<String> ip1List = Arrays.asList(ip1Split);
        for (int i = 0; i < maskList.size(); i++) {
            String s = maskList.get(i);
            String s1 = ip1List.get(i);
            int i1 = Integer.parseInt(s) & Integer.parseInt(s1);
            res.append(i1);
        }
        return res.toString();
    }

    public static boolean ipRight(String ip) {
        String[] split = ip.split("\\.");
        if (split.length > 4) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            if (Integer.parseInt(split[i]) > 255 || Integer.parseInt(split[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isErrorMask(String mask) {
        String[] maskSplit = mask.split("\\.");
        for (int i = 0; i < maskSplit.length; i++) {
            if (Integer.parseInt(maskSplit[i]) > 255 || Integer.parseInt(maskSplit[i]) < 0) {
                return true;
            }
        }
        StringBuilder maskBinaryBuilder = new StringBuilder("");
        for (String maskPart : maskSplit) {
            int anInt = Integer.parseInt(maskPart);
            String binaryString = binaryString(anInt);
            maskBinaryBuilder.append(binaryString);
        }
        String maskBinaryString = maskBinaryBuilder.toString();
        if (!maskBinaryString.contains("0") || !maskBinaryString.contains("1")) {
            return true;
        }
        int index = maskBinaryString.lastIndexOf("1");
        String onePart = maskBinaryString.substring(0, index + 1);
        String zeroPart = maskBinaryString.substring(index + 1);
        if (onePart.contains("0") || zeroPart.contains("1")) {
            return true;
        }
        return false;
    }

    /**
     * 将整数转成对应的八位二进制字符串
     *
     * @param num
     * @return
     */
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }
}
