package com.huawei.practise;

import java.util.Scanner;

/**
 * 二维数组操作
 *
 * 题目描述
 * 有一个大小的数据表，你会依次进行以下5种操作：
 * 1.输入和，初始化大小的表格。
 * 2.输入x_1x
 * 1
 * ​
 *  、y_1y
 * 1
 * ​
 *  、x_2x
 * 2
 * ​
 *  、y_2y
 * 2
 * ​
 *  ，交换坐标在(x_1,y_1)(x
 * 1
 * ​
 *  ,y
 * 1
 * ​
 *  )和(x_2,y_2)(x
 * 2
 * ​
 *  ,y
 * 2
 * ​
 *  )的两个数。
 * 3.输入，在第行上方添加一行。
 * 4.输入，在第列左边添加一列。
 * 5.输入、，查找坐标为的单元格的值。
 * 请编写程序，判断对表格的各种操作是否合法。
 *
 * 详细要求:
 *
 * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
 * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的大小，多出的数据则应舍弃。
 * 3.所有输入坐标操作，对大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。超出范围应该返回错误。
 *
 * 本题含有多组样例输入！
 * 输入描述:
 * 输入数据按下列顺序输入：
 * 1 表格的行列值
 * 2 要交换的两个单元格的行列值
 * 3 输入要插入的行的数值
 * 4 输入要插入的列的数值
 * 5 输入要查询的单元格的坐标
 *
 * 输出描述:
 * 输出按下列顺序输出：
 * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 * 2 输出交换单元格是否成功
 * 3 输出插入行是否成功
 * 4 输出插入列是否成功
 * 5 输出查询单元格数据是否成功
 *
 * 示例1
 * 输入
 * 复制
 * 4 9
 * 5 1 2 6
 * 0
 * 8
 * 2 3
 * 4 7
 * 4 2 3 2
 * 3
 * 3
 * 4 7
 * 输出
 * 复制
 * 0
 * -1
 * 0
 * -1
 * 0
 * 0
 * -1
 * 0
 * 0
 * -1
 * 说明
 * 本组样例共有2组样例输入。
 * 第一组样例：
 * 1.初始化数据表为4行9列，成功
 * 2.交换第5行1列和第2行6列的数据，失败。因为行的范围应该是(0,3)，不存在第5行。
 * 3.在第0行上方添加一行，成功。
 * 4.在第8列左边添加一列，失败。因为列的总数已经达到了9的上限。
 * 5.查询第2行第3列的值，成功。
 * 第二组样例：
 * 1.初始化数据表为4行7列，成功
 * 2.交换第4行2列和第3行2列的数据，失败。因为行的范围应该是(0,3)，不存在第4行。
 * 3.在第3行上方添加一行，成功。
 * 4.在第3列左边添加一列，成功。
 * 5.查询第4行7列的值，失败。因为虽然添加了一行一列，但数据表会在添加后恢复成4行7列的形态，所以行的区间仍然在[0,3]，列的区间仍然在[0,6]，无法查询到(4,7)坐标。
 */
public class Hj83Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            StringBuilder result = new StringBuilder();
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            if (m > 9 || n > 9) {
                result.append(-1).append("\n");
            } else {
                result.append(0).append("\n");
                int[][] arr = new int[m][n];
                String line1 = scanner.nextLine();
                String[] s1 = line1.split(" ");
                int x1 = Integer.parseInt(s1[0]);
                int y1 = Integer.parseInt(s1[1]);
                int x2 = Integer.parseInt(s1[2]);
                int y2 = Integer.parseInt(s1[3]);
                if (x1 >= m || y1 >= n || x2 >= m || y2 >= n) {
                    result.append(-1).append("\n");
                } else {
                    result.append(0).append("\n");
                    int temp = arr[x1][y1];
                    arr[x1][y1] = arr[x2][y2];
                    arr[x2][y2] = temp;
                }
                int i = Integer.parseInt(scanner.nextLine());
                if (m + 1 > 9 || i>=m) {
                    result.append(-1).append("\n");
                } else {
                    result.append(0).append("\n");
                }
                int i1 = Integer.parseInt(scanner.nextLine());
                if (n + 1 > 9 || i1>=n) {
                    result.append(-1).append("\n");
                } else {
                    result.append(0).append("\n");
                }
                String line2 = scanner.nextLine();
                String[] s2 = line2.split(" ");
                int j = Integer.parseInt(s2[0]);
                int j1 = Integer.parseInt(s2[1]);
                if (j >= m || j1 >= n) {
                    result.append(-1);
                } else {
                    result.append(0);
                }
            }
            System.out.print(result.toString());
            System.out.println();
        }
    }
}
