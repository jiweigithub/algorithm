package com.shangguigu.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 * 把n个待排序的元素看成一个有序表和一个无序表，
 * 开始时有序表中只有一个元素，无序表中包含n-1个元素，
 * 排序过程中每次从无需表中取出第一个元素，
 * 把它的排序码依次与有序表元素的排序码进行比较，
 * 将它插入到有序表中的适当位置（有序码中的元素后移），使之称为新的有序表。
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 25, 1, -1, 89};
//        insertSort(arr);
//        insertDescSort(arr);

        //测试插入排序的执行时间
        //创建有80000个随机数的数组
//        int[] arr = new int[80000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String start = dateFormat.format(new Date());
        System.out.println("排序前：" + start);
        insertSort(arr);
        String end = dateFormat.format(new Date());
        System.out.println("排序后：" + end);
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertSort(int[] array) {
       /* //使用逐步推导的方式
        //第一轮{101, 34, 25, 1}->{34, 101 ,25, 1}
        //定义待插入的数
        int insertVal = array[1];
        //定义一个待插入数的索引 即array[1]前面一个数的下标
        int insertIndex = 1 - 1;
        //给insertVal找到插入的位置
        //1.insertIndex >= 0 保证在给insertVal找插入位置时，不越界
        //2.insertVal < array[insertIndex] 待插入的值还未找到插入的位置
        //3.满足以上两个条件，就将array[insertIndex] 后移 array[insertIndex + 1] = array[insertIndex];
        while (insertIndex >= 0 && insertVal < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到, insertIndex+1
        array[insertIndex + 1] = insertVal;

        System.out.println("第一轮插入后");
        System.out.println(Arrays.toString(array));

        insertVal = array[2];
        insertIndex = 2 - 1;

        while (insertIndex >= 0 && insertVal < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到, insertIndex+1
        array[insertIndex + 1] = insertVal;

        System.out.println("第二轮插入后");
        System.out.println(Arrays.toString(array));

        insertVal = array[3];
        insertIndex = 3 - 1;

        while (insertIndex >= 0 && insertVal < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到, insertIndex+1
        array[insertIndex + 1] = insertVal;

        System.out.println("第三轮插入后");
        System.out.println(Arrays.toString(array));*/

        //使用for循环写出通用算法
        for (int i = 1; i < array.length; i++) {
            //待插入数为array[i]
            int insertVal = array[i];
            //初始插入位置为i-1
            int insertIndex = i;
            //当insertIndex - 1不小于0（不越界）且待插入数小于前面有序数列的最后一位array[insertIndex - 1]
            while (insertIndex - 1 >= 0 && insertVal < array[insertIndex - 1]) {
                //array[insertIndex]后移
                array[insertIndex] = array[insertIndex - 1];
                //插入位置向前移动一位
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到, insertIndex
            array[insertIndex] = insertVal;
            System.out.printf("第%d轮插入后\n", i);
            System.out.println(Arrays.toString(array));
        }

    }

    //降序
    public static void insertDescSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //待插入数为array[i]
            int insertVal = array[i];
            //初始插入位置为i-1
            int insertIndex = i;
            //当insertIndex不小于0（不越界）且待插入数小于array[insertIndex]
            while (insertIndex - 1 >= 0 && insertVal > array[insertIndex - 1]) {
                //array[insertIndex]后移
                array[insertIndex] = array[insertIndex - 1];
                //插入位置向前移动一位
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到, insertIndex+1
            array[insertIndex] = insertVal;
//            System.out.printf("第%d轮插入后\n", i);
//            System.out.println(Arrays.toString(array));
        }
    }

}
