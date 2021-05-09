package com.huawei.leetcode;

/**
 * 最大数
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 */
public class Solution179 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        Solution179 solution179 = new Solution179();
        solution179.largestNumber(nums);
    }

    public String largestNumber(int[] nums) {
        sortNums(nums);
        if (nums[0] == 0) {
            return "0";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                stringBuilder.append(nums[i]);
            }
            return stringBuilder.toString();
        }
    }

    public void sortNums(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                String v1 = nums[j] + "";
                String v2 = nums[j + 1] + "";
                if (v1.charAt(0) < v2.charAt(0)) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                } else {
                    String val1 = v1 + v2;
                    String val2 = v2 + v1;
                    if (val1.compareTo(val2) < 0) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
    }

}
