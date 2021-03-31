package com.shangguigu.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(arr);

        //测试插入排序的执行时间
        //创建有80000个随机数的数组
        int[] arr = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String start = dateFormat.format(new Date());
        System.out.println("排序前：" + start);
        shellSort2(arr);
        String end = dateFormat.format(new Date());
        System.out.println("排序后：" + end);
    }

    /**
     * 使用逐步推导的方式编写希尔排序(交换法)
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        /*int temp = 0;
        //希尔排序的第一轮排序
        //因为第一轮排序是将10个数据分成了5组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素（共有5组，每组有2个元素）,所以步长为5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));

        //希尔排序的第二轮排序
        //因为第二轮排序是将10个数据分成了2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素（共有2组，每组有2个元素）,所以步长为2
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序2轮后=" + Arrays.toString(arr));


        //希尔排序的第三轮排序
        //因为第三轮排序是将10个数据分成了1组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有的元素（共有2组，每组有2个元素）,所以步长为2
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序3轮后=" + Arrays.toString(arr));*/

        //写出通用代码
        int tempVal = 0;
        int count = 0;
        //根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共有gap组，每组有gap个元素）,所以步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        tempVal = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tempVal;
                    }
                }
            }
//            System.out.println("希尔排序" + (++count) + "轮后=" + Arrays.toString(arr));
        }
    }

    /**
     * 使用逐步推导的方式编写希尔排序(移位法)
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {

        /*//第一轮
        int gap = arr.length / 2;
        for (int i = gap; i < arr.length; i++) {
            //待插入数为array[i]
            int insertVal = arr[i];
            int insertIndex = i;
            //当insertIndex - gap不小于0（不越界）且待插入数小于array[insertIndex - gap]
            while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                //array[insertIndex]移动
                arr[insertIndex] = arr[insertIndex - gap];
                //插入位置向前移动gap位
                insertIndex -= gap;
            }
            //当退出while循环时，说明插入的位置找到, insertIndex
            arr[insertIndex] = insertVal;
        }
        System.out.println("第1轮希尔排序后");
        System.out.println(Arrays.toString(arr));

        //第2轮
        gap = arr.length / 2 / 2;
        for (int i = gap; i < arr.length; i++) {
            //待插入数为array[i]
            int insertVal = arr[i];
            int insertIndex = i;
            //当insertIndex - gap不小于0（不越界）且待插入数小于array[insertIndex - gap]
            while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                //array[insertIndex]移动
                arr[insertIndex] = arr[insertIndex - gap];
                //插入位置向前移动一位
                insertIndex -= gap;
            }
            //当退出while循环时，说明插入的位置找到, insertIndex+gap
            arr[insertIndex] = insertVal;
        }
        System.out.println("第2轮希尔排序后");
        System.out.println(Arrays.toString(arr));

        //第3轮
        gap = arr.length / 2 / 2 / 2;
        for (int i = gap; i < arr.length; i++) {
            //待插入数为array[i]
            int insertVal = arr[i];
            int insertIndex = i;
            //当insertIndex - gap不小于0（不越界）且待插入数小于array[insertIndex - gap]
            while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                //array[insertIndex-gap]移动至arr[insertIndex]
                arr[insertIndex] = arr[insertIndex - gap];
                //插入位置向前移动gap位
                insertIndex -= gap;
            }
            //当退出while循环时，说明插入的位置找到, insertIndex+gap
            arr[insertIndex] = insertVal;
        }
        System.out.println("第3轮希尔排序后");
        System.out.println(Arrays.toString(arr));*/

        int count = 0;
        //增量gap,并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始逐个对其所在的组进行简单直接插入
            for (int i = gap; i < arr.length; i++) {
                int currentIndex = i;
                int temp = arr[currentIndex];
                while (currentIndex - gap >= 0 && temp < arr[currentIndex - gap]) {
                    //移动
                    arr[currentIndex] = arr[currentIndex - gap];
                    currentIndex -= gap;
                }
                //当退出while循环后，就给temp找到了插入的位置
                arr[currentIndex] = temp;
            }
//            System.out.println("希尔排序" + (++count) + "轮后=" + Arrays.toString(arr));
        }
    }
}
