package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * leetcode-167：两数之和 II - 输入有序数组
 *
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 思路：
 * 只要数组有序，就应该想到双指针技巧。这道题的解法有点类似二分查找，通过调节 left 和 right 就可以调整 sum 的大小
 *
 * @Author black mamba
 * @Date 2025/3/14 23:07
 * @Version 1.0
 */
public class TwoSum {

    public static int[] solution(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = solution(numbers, target);
        System.out.println(Arrays.toString(result));


    }
}
