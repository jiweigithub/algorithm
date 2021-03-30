package com.shangguigu.algorithm.search;

import java.util.Arrays;

/**
 * 斐波那契查找F[k] = F[k-1]+F[k-2]
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        int[] arr = {-22, -16, -11, -7, -4, -2, -1, 0, 1, 2, 4, 7, 11, 16, 22};
        int target = 0;
        int i = fibonacciSearch(arr, target);
        System.out.println(i);
    }

    /**
     * 获取斐波那契数列
     *
     * @return
     */
    public static int[] getFibonacciArray(int length) {
        int[] f = new int[length];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找
     *
     * @param arr    有序序列
     * @param target 目标值
     * @return int 目标值索引 如果没有返回-1
     */
    public static int fibonacciSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        //表示斐波那契分割数值的下标
        int k = 0;
        //存放mid值
        int mid = 0;
        //获取到斐波那契数列
        int[] f = getFibonacciArray(arr.length);
        //获取到斐波那契分割数值的下标
        while (right > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于arr数组的长度,因此我们需要使用Arrays类，构造一个新的数组，并指向arr
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需要使用arr[right]填充temp
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        while (left <= right) {
            mid = left + f[k - 1] - 1;
            if (target < arr[mid]) {
                right = mid - 1;
                k--;
            } else if (target > arr[mid]) {
                left = mid + 1;
                k -= 2;
            } else {
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }
}
