package com.example.algorithm.zijie;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/24 21:46
 * @Version 1.0
 *
 * 标题
 * 旋转数组找指定值
 *
 * 题目描述
 * 将一个值不重复的递增数组在某一个下标处进行旋转，比如 [0,1,2,4,5,6,7]旋转之后变成[4,5,6,7,0,1,2]，现在给定一个目标值，要求实现一个算法，查找该数组中是否包含这个值，如果有则返回该值对应的下标，若不存在返回-1.​
 *
 * 输入：
 * arr := []int{4,5,6,7,0,1,2}
 * t := 7
 * 输出：3
 *
 * 解法：先通过二分查找的方式，判断中间值和目标值的关系以及中间值左右两侧的有序性，逐步缩小查找范围，直到找到目标值或者确定目标值不存在。
 */
public class RotatedArraySearchSolution {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int t = 7;
        System.out.println(search(arr, t));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 判断 mid 左侧是否有序
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // mid 右侧有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
