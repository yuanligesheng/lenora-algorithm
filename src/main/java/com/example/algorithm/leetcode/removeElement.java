package com.example.algorithm.leetcode;

/**
 * leetcode-27:移除元素
 *
 * 使用快慢指针技巧：
 * 如果 fast 遇到值为 val 的元素，则直接跳过，否则就赋值给 slow 指针，并让 slow 前进一步
 *
 * 注意这里和有序数组去重的解法有一个细节差异，这里是先给 nums[slow] 赋值然后再给 slow++，这样可以保证 nums[0..slow-1]
 * 是不包含值为 val 的元素的，最后的结果数组长度就是 slow。
 *
 * @Author Wang Haoyu
 * @Date 2025/3/13 01:22
 * @Version 1.0
 */
public class removeElement {

    public static int solutiong(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(solutiong(nums, val));
    }
}
