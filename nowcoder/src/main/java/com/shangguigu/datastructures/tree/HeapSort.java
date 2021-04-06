package com.shangguigu.datastructures.tree;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, -1, 3, 7};
        sort(arr);
    }

    public static void sort(int[] arr) {
        System.out.println("堆排序");
        int length = arr.length;
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            buildHeap(arr, i, arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            buildHeap(arr, 0, j);//重新对堆进行调整
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 构建大顶堆
     *
     * @param arr    待排序数组
     * @param i      表示非叶子节点的下标
     * @param length 表示对多少个元素进行调整(length在逐渐减少)
     */
    public static void buildHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量
        int temp = arr[i];
        //开始调整
        //k指向的是i节点的左子节点
        //一次遍历后，接着处理k的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //说明i的左子节点小于i的右子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //k指向i的右子节点
                k++;
            }
            //如果i子节点中的较大值大于i节点的值
            if (arr[k] > temp) {
                //将较大值赋给当前节点
                arr[i] = arr[k];
                //将i指向k
                i = k;
            } else {
                break;
            }
        }
        //将temp放到最终的位置
        arr[i] = temp;
    }

    public static void buildHeap2(int[] arr, int i, int length) {
        int temp;
        //当前节点索引
        int largest = i;
        //当前节点左子节点索引
        int left = i * 2 + 1;
        //当前节点右子节点索引
        int right = i * 2 + 2;
        //如果左节点的值大于初始最大值节点的值
        if (left < length && arr[left] > arr[largest]) {
            //最大值节点的索引指向当左节点
            largest = left;
        }
        //如果右节点的值大于初始最大值节点的值
        if (right < length && arr[right] > arr[largest]) {
            //最大值节点的索引指向当右节点
            largest = right;
        }
        //如果最大值节点索引不等于当前节点索引
        if (largest != i) {
            //交换当前索引节点的值与最大值节点的值
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }

        buildHeap2(arr, largest, length);
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
