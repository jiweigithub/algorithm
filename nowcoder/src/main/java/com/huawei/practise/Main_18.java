package com.huawei.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 识别有效的IP地址和掩码并进行分类统计
 */
public class Main_18 {

    public static boolean isNumber(String str) {
        if (str.length() < 1) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isErrorIp(String ipAddr) {
        String[] ipSplit = ipAddr.split("\\.");
        for (String ipPart : ipSplit) {
            if (!isNumber(ipPart)) {
                return true;
            }
        }
        int ipPart1 = Integer.parseInt(ipSplit[0]);
        Integer ipPart2 = Integer.parseInt(ipSplit[1]);
        Integer ipPart3 = Integer.parseInt(ipSplit[2]);
        Integer ipPart4 = Integer.parseInt(ipSplit[3]);
        int ipPart3_4 = ipPart2 + ipPart3 + ipPart4;
        return ipPart1 == 127 || ipPart3_4 > 765 || ipPart1 < 1 || ipPart1 > 255;
    }

    public static String getIpType(String ipAddr) {
        String type = "X";
        String[] ipSplit = ipAddr.split("\\.");
        int ipPart1 = Integer.parseInt(ipSplit[0]);
        if (ipPart1 >= 1 && ipPart1 <= 126) {
            type = "A";
        }
        if (ipPart1 >= 128 && ipPart1 <= 191) {
            type = "B";
        }
        if (ipPart1 >= 192 && ipPart1 <= 223) {
            type = "C";
        }
        if (ipPart1 >= 224 && ipPart1 <= 239) {
            type = "D";
        }
        if (ipPart1 >= 240 && ipPart1 <= 255) {
            type = "E";
        }
        return type;
    }

    public static boolean isPrivateIp(String ipAddr) {
        String[] ipSplit = ipAddr.split("\\.");
        int ipPart1 = Integer.parseInt(ipSplit[0]);
        int ipPart2 = Integer.parseInt(ipSplit[1]);
        if (ipPart1 == 10) {
            return true;
        }
        if (ipPart1 == 172 && ipPart2 >= 16 && ipPart2 <= 31) {
            return true;
        }
        return ipPart1 == 192 && ipPart2 == 168;
    }

    public static boolean isErrorMask(String mask) {
        String[] maskSplit = mask.split("\\.");
        StringBuilder maskBinaryBuilder = new StringBuilder("");
        for (String maskPart : maskSplit) {
            if (!isNumber(maskPart)) {
                return true;
            }
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int errIpOrMask = 0;
        int privateIpCount = 0;
        while ((input = br.readLine()) != null && !input.equals("")) {
            String[] ipArray = input.split("~");
            if (ipArray.length > 1) {
                String ipAddr = ipArray[0];
                String ipMask = ipArray[1];
                boolean errorMask = isErrorMask(ipMask);
                if (errorMask) {
                    errIpOrMask++;
                } else {
                    boolean privateIp = isPrivateIp(ipAddr);
                    if (privateIp) {
                        privateIpCount++;
                    }
                    String ipType = getIpType(ipAddr);
                    switch (ipType) {
                        case "A":
                            a++;
                            break;
                        case "B":
                            b++;
                            break;
                        case "C":
                            c++;
                            break;
                        case "D":
                            d++;
                            break;
                        case "E":
                            e++;
                            break;
                    }
                }
            }
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + errIpOrMask + " " + privateIpCount);
    }

}
