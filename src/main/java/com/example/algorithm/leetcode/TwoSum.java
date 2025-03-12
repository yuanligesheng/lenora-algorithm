package com.example.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode-1：两数之和
 * @Author Wang Haoyu
 * @Date 2024/8/31 17:03
 * @Version 1.0
 */
public class TwoSum {
    /**
     * 给一组数组和一个和的目标值，找出等于目标值的组合的下标
     * 利用哈希map，先计算另一个数，另一个数在哈希中存在则返回结果中，没有则把当前值放入到哈希中，继续遍历，时间复杂度为n
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        /* key为元素值，value为每个元素对应的下标*/
        Map<Integer, Integer> storeNums = new HashMap<>(nums.length, 1);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            Integer anotherIndex = storeNums.get(another);
            if (null != anotherIndex) {
                result[0] = anotherIndex;
                result[1] = i;
                break;
            } else {
                storeNums.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums ={4,6,7,13,18};
        int[] result = twoSum(nums, 20);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + "="  + nums[result[i]]);
        }
    }
}
