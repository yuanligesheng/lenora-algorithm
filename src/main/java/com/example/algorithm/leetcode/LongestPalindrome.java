package com.example.algorithm.leetcode;

/**
 * leetcode-5:最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 思路：
 * 找回文串的难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧。
 * 如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符。所以我们可以先实现这样一个函数palindrome。
 * 如果输入相同的 l 和 r，就相当于寻找长度为奇数的回文串，如果输入相邻的 l 和 r，则相当于寻找长度为偶数的回文串。
 * @Author black mamba
 * @Date 2025/3/14 23:48
 * @Version 1.0
 */
public class LongestPalindrome {

    static String solution(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);

            // res = longest(res, s1, s2)
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    static String palindrome(String s, int left, int right) {
        // 防止索引越界
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 双指针，向两边展开
            left--;
            right++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String s = "yujabcddcbah";
        System.out.println(solution(s));
    }
}
