package com.example.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode-3 无重复字符的最长子串
 *
 * @Author Wang Haoyu
 * @Date 2024/8/31 23:13
 * @Version 1.0
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }

        public static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> dic = new HashMap<>();
            int i = -1, res = 0, len = s.length();
            for(int j = 0; j < len; j++) {
                if (dic.containsKey(s.charAt(j))) {
                    i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
                }
                dic.put(s.charAt(j), j); // 哈希表记录
                res = Math.max(res, j - i); // 更新结果
            }
            return res;
        }
}
