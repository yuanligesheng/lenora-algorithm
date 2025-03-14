package com.example.algorithm.leetcode;

/**
 * 回文串判断
 * <p>
 * 回文串就是正着读和反着读都一样的字符串。比如说字符串 aba 和 abba 都是回文串，因为它们对称，反过来还是和本身一样；反之，字符串 abac 就不是回文串。
 *
 * @Author black mamba
 * @Date 2025/3/14 23:42
 * @Version 1.0
 */
public class IsPalindrome {

    public static boolean solution(String s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(solution(s));
    }
}
