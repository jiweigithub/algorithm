package com.shangguigu.algorithm.search;

/**
 * 插值查找
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {-22, -16, -11, -7, -4, -2, -1, 0, 1, 2, 4, 7, 11, 16, 22};
        int target = -23;
        int search = search(arr, target);
        System.out.println(search);
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        return interpolationSearch(arr, left, right, target);
    }

    public static int interpolationSearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (target - arr[left]) * (right - left) / (arr[right] - arr[left]);
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
