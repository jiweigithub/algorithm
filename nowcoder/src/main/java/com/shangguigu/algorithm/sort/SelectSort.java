package com.shangguigu.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 * <p>
 * 第一次从array[0]~array[n-1]中选取最小值，与array[0]交换，
 * 第二次从array[1]~array[n-1]中选取最小值，与array[1]交换，
 * 第三次从array[2]~array[n-1]中选取最小值，与array[2]交换，
 * 。。。
 * 第i次从array[i-1]~array[n-1]中选取最小值，与array[i-1]交换，
 * 第n-1次从array[n-2]~array[n-1]中选取最小值，与array[n-2]交换，
 * 总共通过n-1次，得到一个排序从小到大排列的有序序列。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 9, -1, 10, -2};
        sort(array);
//        System.out.println(Arrays.toString(array));

        //测试选择排序的执行时间
        //创建有80000个随机数的数组
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String start = dateFormat.format(new Date());
        System.out.println("排序前：" + start);
        sort(arr);
        String end = dateFormat.format(new Date());
        System.out.println("排序后：" + end);
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            //如果当前最小值的下标不等于i
            if (index != i) {
                array[index] = array[i];
                array[i] = min;
            }
        }
    }
}
