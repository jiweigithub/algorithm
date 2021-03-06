package com.shangguigu.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 * <p>
 * 通过对待排序序列从前到后（从下标较小的元素开始），
 * 依次比较相邻元素的值，若发现逆序则交换，
 * 使值较大的元素逐渐从前移动至后部，
 * 就像水底下的气泡一样逐渐向上冒。
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{10, 2, 3, 1, 6, 5, 7};
//        bubbleSort.ascSort(array);
//        bubbleSort.descSort(array);

        //测试冒泡排序的执行时间
        //创建有80000个随机数的数组
//        int[] arr = new int[80000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 800000);
//        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String start = dateFormat.format(new Date());
        System.out.println("排序前：" + start);
        bubbleSort.ascSort(arr);
        String end = dateFormat.format(new Date());
        System.out.println("排序后：" + end);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 正序
     *
     * @param array
     */
    public void ascSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array.length - 1 - i; ++j) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
//            System.out.printf("第%d次排序，排序后的数组\n", i + 1);
//            System.out.println(Arrays.toString(array));
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    /**
     * 逆序
     *
     * @param array
     */
    public void descSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.printf("第%d次排序，排序后的数组\n", i + 1);
            System.out.println(Arrays.toString(array));
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
    }
}
