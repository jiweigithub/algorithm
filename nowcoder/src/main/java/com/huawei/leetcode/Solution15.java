package com.huawei.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> row : lists) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        //如果数组长度小于3 不可能得到结果直接返回
        if (len < 3) {
            return ans;
        }
        //对数组进行排序,从小到大自然排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //如果nums[i]大于0 则i之后所有的数都大于0，和肯定大于0循环结束
            if (nums[i] > 0) {
                break;
            }
            //如果nums[i] == nums[i-1]，由于nums[i-1]的解已经处理过了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //左边界下标
            int l = i + 1;
            //右边界下标
            int r = nums.length - 1;
            //如果左边界小于右
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                //如果sum == 0 说明找到了一组解
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //去重
                    while (l < r && nums[l] == nums[l] + 1) {
                        l++;
                    }
                    //去重
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    //如果sum<0说明三个数的和太小，l++ ，将最小的值换成它大的一个（sort之后是由小到大排序的）
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
