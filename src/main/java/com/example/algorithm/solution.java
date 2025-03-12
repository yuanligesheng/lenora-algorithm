package com.example.algorithm;

import java.util.HashMap;

/**
 * @Author Wang Haoyu
 * @Date 2024/10/12 22:03
 * @Version 1.0
 */
public class solution {

    public int[] twosum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
