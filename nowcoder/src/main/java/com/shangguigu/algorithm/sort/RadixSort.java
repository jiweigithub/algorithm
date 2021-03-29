package com.shangguigu.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {-53, 3, 542, 748, 14, 214};
        radixSort(arr);
//        int[] arr = new int[8000000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 800000);
//        }
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        String start = dateFormat.format(new Date());
//        System.out.println("排序前：" + start);
//        radixSort(arr);
//        String end = dateFormat.format(new Date());
//        System.out.println("排序后：" + end);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //第一轮排序（针对每个元素的个位进行排序处理）
        //定义一个二维数据表示10个桶,每个桶就是一个一维数组
        int[][] buckets = new int[10][arr.length];
        //为了记录每个桶中实际存放了多少个数据
        // 定义一个一维数组,来记录每个桶中每次放入数据的个数
        // 例如：bucketElementCount[0]
        // 记录的就是bucket[0]这个桶中放入数据的下标
        int[] bucketElementCount = new int[10];

        /*//第一轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] % 10;
            //放入到对应的桶中
            int index = bucketElementCount[digitOfElement];
            buckets[digitOfElement][index] = arr[j];
            bucketElementCount[digitOfElement] += 1;
        }
        //从桶中按照顺序依次取出桶中的数据，放入原来的数组
        int index = 0;
        //遍历桶
        for (int i = 0; i < buckets.length; i++) {
            //将每个桶中的数据依次取出
            if (bucketElementCount[i] > 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    //取出元素，放入到arr中
                    arr[index] = buckets[i][j];
                    index++;
                }
            }
            //每轮处理结束后，需要将bucketElementCount[i] = 0 !!!
            bucketElementCount[i] = 0;
        }
        System.out.println(Arrays.toString(arr));


        //第二轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] / 10 % 10;
            //放入到对应的桶中
            index = bucketElementCount[digitOfElement];
            buckets[digitOfElement][index] = arr[j];
            bucketElementCount[digitOfElement] += 1;
        }
        //从桶中按照顺序依次取出桶中的数据，放入原来的数组
        index = 0;
        //遍历桶
        for (int i = 0; i < buckets.length; i++) {
            //将每个桶中的数据依次取出
            if (bucketElementCount[i] > 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    //取出元素，放入到arr中
                    arr[index] = buckets[i][j];
                    index++;
                }
            }
            //每轮处理结束后，需要将bucketElementCount[i] = 0 !!!
            bucketElementCount[i] = 0;
        }
        System.out.println(Arrays.toString(arr));

        //第三轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] / 100 % 10;
            //放入到对应的桶中
            index = bucketElementCount[digitOfElement];
            buckets[digitOfElement][index] = arr[j];
            bucketElementCount[digitOfElement] += 1;
        }
        //从桶中按照顺序依次取出桶中的数据，放入原来的数组
        index = 0;
        //遍历桶
        for (int i = 0; i < buckets.length; i++) {
            //将每个桶中的数据依次取出
            if (bucketElementCount[i] > 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    //取出元素，放入到arr中
                    arr[index] = buckets[i][j];
                    index++;
                }
            }
            //每轮处理结束后，需要将bucketElementCount[i] = 0 !!!
            bucketElementCount[i] = 0;
        }
        System.out.println(Arrays.toString(arr));*/


        //写出通用代码
        //1.得到数组中最大的数的位数
        int max = arr[0];
        int min = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        if (min < 0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] -= min;
                max -= min;
            }
        }

        //得到最大数是几位
        int maxLength = (max + "").length();

        for (int m = 0, n = 1; m < maxLength; m++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                int index = bucketElementCount[digitOfElement];
                buckets[digitOfElement][index] = arr[j];
                bucketElementCount[digitOfElement] += 1;
            }
            //从桶中按照顺序依次取出桶中的数据，放入原来的数组
            int index = 0;
            //遍历桶
            for (int i = 0; i < buckets.length; i++) {
                //将每个桶中的数据依次取出
                if (bucketElementCount[i] > 0) {
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        //取出元素，放入到arr中
                        arr[index] = buckets[i][j];
                        index++;
                    }
                }
                //每轮处理结束后，需要将bucketElementCount[i] = 0 !!!
                bucketElementCount[i] = 0;
            }
//            System.out.println(Arrays.toString(arr));
        }
        if (min < 0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] += min;
            }
        }
    }
}
