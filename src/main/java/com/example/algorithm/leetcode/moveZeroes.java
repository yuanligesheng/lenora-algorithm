package com.example.algorithm.leetcode;

/**
 * leetcode-283：移动零
 * 给你输入一个数组 nums，请你原地修改，将数组中的所有值为 0 的元素移到数组末尾
 *
 * 题目让我们将所有 0 移到最后，其实就相当于移除 nums 中的所有 0，然后再把后面的元素都赋值为 0
 *
 * @Author ghost_why
 * @Date 2025/3/13 01:40
 * @Version 1.0
 */
public class moveZeroes {

    public static void solution(int[] nums) {
        if (nums.length ==0) {
            return ;
        }
        int fast = 0, slow =0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
    }
}
