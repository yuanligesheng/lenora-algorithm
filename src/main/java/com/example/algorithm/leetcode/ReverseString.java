package com.example.algorithm.leetcode;

/**
 * leetcode-344: 反转字符串
 * <p>
 * 反转一个 char[] 类型的字符数组
 *
 * @Author black mamba
 * @Date 2025/3/14 23:32
 * @Version 1.0
 */
public class ReverseString {
    public static char[] solution(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
        return s;
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(solution(s));
    }
}


/**
 * 思路：
 * 双指针，一左一右两个指针相向而行
 */
