package com.shangguigu.algorithm.search;

/**
 * 二分查找(只能用有序序列进行查找)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = search(arr, 1234);
        if (index == -1) {
            System.out.println("未查找到数据");
        } else {
            System.out.println("下标为：" + index);
        }
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
//        return binarySearch(arr, left, right, target);
        return binarySearch2(arr,target);
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            return binarySearch(arr, left, right, target);
        } else {
            return -1;
        }
    }

    public static int binarySearch2(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //如果目标值小于arr[mid],说明目标值在left和mid之间
            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
