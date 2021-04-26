package com.huawei.practise;

import java.util.*;

/**
 * 题目描述
 * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
 * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
 * <p>
 * 请注意本题有多组输入用例。
 * 输入描述:
 * ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~0xFFFFFFFF，序列个数不限
 * <p>
 * 输出描述:
 * ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：
 * <p>
 * I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
 * <p>
 * 按R<i>从小到大的顺序:
 * <p>
 * (1)先输出R<i>；
 * <p>
 * (2)再输出满足条件的I的个数；
 * <p>
 * (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
 * <p>
 * (4)最后再输出I。
 * <p>
 * 附加条件：
 * <p>
 * (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
 * <p>
 * (2)如果没有满足条件的I，对应的R<i>不用输出
 * <p>
 * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
 * <p>
 * <p>
 * <p>
 * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
 * <p>
 * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
 * <p>
 * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
 * <p>
 * 说明：
 * <p>
 * 30----后续有30个整数
 * <p>
 * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
 * <p>
 * 6--- 存在6个包含3的I
 * <p>
 * 0--- 123所在的原序号为0
 * <p>
 * 123--- 123包含3，满足条件
 * <p>
 * 示例1
 * 输入
 * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
 * 5 6 3 6 3 0
 * 输出
 * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123
 * <p>
 * 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 */
public class Hj25Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String iInput = sc.nextLine();
            String rInput = sc.nextLine();
            String[] iSplit = iInput.split(" ");
            String[] rSplit = rInput.split(" ");

            printResult1(iSplit, rSplit);

            printResult2(iSplit, rSplit);


        }
    }

    private static void printResult2(String[] iSplit, String[] rSplit) {
        List<Integer> iList = new ArrayList<>();
        TreeSet<Integer> rSet = new TreeSet<>();
        for (int i = 1; i < iSplit.length; i++) {
            iList.add(Integer.parseInt(rSplit[i]));
        }
        for (int i = 1; i < iSplit.length; i++) {
            rSet.add(Integer.parseInt(rSplit[i]));
        }
        List<Integer> rList = new ArrayList<>(rSet);
        List<OutPut> outPutList = new ArrayList<>();
        for (int i = 0; i < rList.size(); i++) {
            int bingoCount = 0;
            OutPut outPut = new OutPut();
            TreeMap<Integer, Integer> indexMap = outPut.getIndexMap();
            for (int j = 0; j < iList.size(); j++) {
                if (String.valueOf(iList.get(j)).contains(String.valueOf(rList.get(i)))) {
                    outPut.setBingo(true);
                    outPut.setBingoNum(rList.get(i));
                    indexMap.put(j, iList.get(j));
                    bingoCount++;
                }
            }
            outPut.setBingoCount(bingoCount);
            if (outPut.getBingo()) {
                outPutList.add(outPut);
            }
        }
        int totalNumCount = 0;
        totalNumCount = totalNumCount + outPutList.size() * 2;
        for (OutPut outPut : outPutList) {
            totalNumCount = totalNumCount + outPut.getIndexMap().keySet().size() * 2;
        }
        List<Integer> resultList = new ArrayList<>();
        resultList.add(totalNumCount);
        for (int i = 0; i < outPutList.size(); i++) {
            OutPut outPut = outPutList.get(i);
            resultList.add(outPut.getBingoNum());
            resultList.add(outPut.getBingoCount());
            TreeMap<Integer, Integer> indexMap = outPut.getIndexMap();
            indexMap.forEach((key, value) -> {
                resultList.add(key);
                resultList.add(value);
            });
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            if (i == resultList.size() - 1) {
                builder.append(resultList.get(i));
            } else {
                builder.append(resultList.get(i));
                builder.append(" ");
            }
        }
        System.out.println(builder.toString());
    }

    static class OutPut {
        boolean bingo = false;
        int bingoNum = 0;
        int bingoCount = 0;
        TreeMap<Integer, Integer> indexMap = new TreeMap<>();

        public void setBingo(boolean bingo) {
            this.bingo = bingo;
        }

        public boolean getBingo() {
            return this.bingo;
        }

        public void setBingoNum(int num) {
            this.bingoNum = num;
        }

        public int getBingoNum() {
            return this.bingoNum;
        }

        public void setBingoCount(int count) {
            this.bingoCount = count;
        }

        public int getBingoCount() {
            return this.bingoCount;
        }

        public TreeMap<Integer, Integer> getIndexMap() {
            return this.indexMap;
        }
    }

    private static void printResult1(String[] iSplit, String[] rSplit) {
        ArrayList<Integer> iArrayList = new ArrayList<>(Integer.parseInt(iSplit[0]));
        ArrayList<Integer> rArrayList = new ArrayList<>(Integer.parseInt(rSplit[0]));
        for(int i=1; i< iSplit.length; i++) {
            iArrayList.add(Integer.parseInt(iSplit[i]));
        }
        for(int r=1; r< rSplit.length; r++) {
            rArrayList.add(Integer.parseInt(rSplit[r]));
        }

        rArrayList.sort(Comparator.naturalOrder());

        ArrayList<Integer> tempIArrayList = new ArrayList<>(iArrayList);

        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> tempRArray = new ArrayList<>();

        rArrayList.forEach(r -> {
            boolean doubleRi = false;
            if (!tempRArray.contains(r)) {
                tempRArray.add(r);
            } else {
                doubleRi = true;
            }
            if (!doubleRi) {
                StringBuilder rsb1 = new StringBuilder();
                StringBuilder rsb2 = new StringBuilder();
                int countRi = 0;
                for (int i = 0; i < tempIArrayList.size(); i++) {
                    if (String.valueOf(tempIArrayList.get(i)).contains(r.toString())) {
                        rsb2.append(i).append(" ");
                        rsb2.append(tempIArrayList.get(i)).append(" ");
                        countRi++;
                    }
                }
                if (countRi > 0) {
                    rsb1.append(r).append(" ");
                    rsb1.append(countRi);
                    StringBuilder rsb12 = rsb1.append(" ").append(rsb2);
                    sb.append(rsb12.toString().trim()).append(" ");
                }
            }
        });
        String trim = sb.toString().trim();
        String[] s = trim.split(" ");
        int totalCount = s.length;
        StringBuilder outPut = new StringBuilder();
        outPut.append(totalCount).append(" ").append(trim);
        System.out.println(outPut.toString());
    }

}
