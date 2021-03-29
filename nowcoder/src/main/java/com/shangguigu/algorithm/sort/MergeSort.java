package com.shangguigu.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println("归并排序后=" + Arrays.toString(arr));

        int[] arr = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        int[] temp = new int[arr.length];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String start = dateFormat.format(new Date());
        System.out.println("排序前：" + start);
        mergeSort(arr, 0, arr.length - 1, temp);
        String end = dateFormat.format(new Date());
        System.out.println("排序后：" + end);
    }

    /**
     * 分+合
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //到合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始下标
     * @param mid   中间索引
     * @param right 最右边下标
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左边有序序列的初始索引
        int i = left;
        //右边有序序列的初始索引
        int j = mid + 1;
        //temp中转数组的当前索引
        int t = 0;
        //先把左右两边(有序)的数据按照规则填充到temp
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                //如果左边有序序列的当前元素小于右边有序序列的当前元素
                //即 将左边的当前元素，填充到temp数组
                //然后t++, i++
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //将有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //将temp数组重新copy到arr,并不是每次都copy所有的
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
