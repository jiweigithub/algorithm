package com.shangguigu.algorithm.search;

/**
 * 线性查找
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        if (index == -1) {
            System.out.println("未查找到数据");
        } else {
            System.out.println("下标为：" + index);
        }
    }

    /**
     * 线性查找(找到一个满足条件的值就返回)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int seqSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
