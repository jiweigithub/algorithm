package com.shangguigu.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序
 */
public class QuickSort {

    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 1, 1, 2, 9, 4, 7, 7, 6};

//        int[] arr = new int[80000000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
        System.out.println("快排前：" + Arrays.toString(arr));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String start = dateFormat.format(new Date());
        System.out.println("排序前：" + start);
        quickSort(arr, 0, arr.length - 1);
        String end = dateFormat.format(new Date());
        System.out.println("排序后：" + end);

//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        count++;
        int basic = arr[right];
        int l = left;
        int r = right;
        int temp;
        while (l < r) {
            //当左标记的值大于basic时，左标记停止移动
            while (l < r && arr[l] <= basic) {
                ++l;
            }
            //当右标记的值小于basic时，右标记停止移动
            while (l < r && arr[r] >= basic) {
                --r;
            }
            if (l < r) {
                //交换左右标记的值;
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        arr[right] = arr[l];
        arr[l] = basic;
        System.out.println("第" + count + "次快排" + Arrays.toString(arr));
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }
}
