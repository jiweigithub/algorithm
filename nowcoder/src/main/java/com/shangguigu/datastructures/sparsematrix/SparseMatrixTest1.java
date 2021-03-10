package com.shangguigu.datastructures.sparsematrix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 稀疏数组
 */
public class SparseMatrixTest1 {

    public static void main(String[] args) throws IOException {
        //1 创建原始的二维数组 11*11
        //0表示无效数据， 1表示黑数据， 2表示蓝数据
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[3][4] = 2;
        //输出原始数组
        System.out.println("原始二维数组");
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组
        //1.遍历原始二维数组，得到有效数据个数
        int sum = 0;
        for (int[] row : chessArray1) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        //2.根据有效数据个数，初始化稀疏数组；
        int[][] sparseArray = new int[sum + 1][3];
        //3.将有效数据存放到稀疏数组中
        //给稀疏数组的第一行赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历原始二维数组，将非零的值存放到sparseArray中
        //count用来记录是第几个非零数据
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        String path = "map.data";

        File file = new File(path);
        if (file.exists()) {
            file.delete();
        } else {
            file.createNewFile();
        }
        //输出稀疏数组
        System.out.println("转换为稀疏数组");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[0].length; j++) {
                if(j==sparseArray[0].length-1) {
                    sb.append(sparseArray[i][j]).append("\n");
                } else {
                    sb.append(sparseArray[i][j]).append("\t");
                }
                System.out.printf("%d\t", sparseArray[i][j]);
            }
            System.out.println();
        }
        System.out.println("即将写入文件的内容：\n"+sb.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(sb.toString().getBytes());
        fileOutputStream.close();


        //将稀疏数组回复成原始二维数组

        FileInputStream fileInputStream = new FileInputStream(path);

        Scanner sc = new Scanner(fileInputStream);

        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        fileInputStream.close();


        System.out.println("读取到的文件内容：\n"+ lines);

        int[][] sparseArray2 = new int[lines.size()][3];



        for(int i=0; i<sparseArray2.length;i++) {
            int[] splitArray = new int[3];
            String[] split = lines.get(i).split("\t");
            for(int k=0; k<split.length; k++) {
                splitArray[k] = Integer.parseInt(split[k]);
            }
            sparseArray2[i] = splitArray;
        }

        //1.读取稀疏数组的第一行数据，根据值初始化二维数组；
        int[] sparseArrayRow = sparseArray2[0];
        int row = sparseArrayRow[0];
        int col = sparseArrayRow[1];
        int[][] chessArray2 = new int[row][col];
        //将稀疏数组中的数据填充到二维数组中
        for (int i = 1; i < sparseArray2.length; i++) {
            chessArray2[sparseArray2[i][0]][sparseArray2[i][1]] = sparseArray2[i][2];
        }

        System.out.println("还原后的二维数组");
        for (int i = 0; i < chessArray2.length; i++) {
            for (int j = 0; j < chessArray2[0].length; j++) {
                System.out.printf("%d\t", chessArray2[i][j]);
            }
            System.out.println();
        }
    }

}
