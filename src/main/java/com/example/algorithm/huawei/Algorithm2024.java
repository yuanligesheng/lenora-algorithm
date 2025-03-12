package com.example.algorithm.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/8/13 17:32
 * @Version 1.0
 */
public class Algorithm2024 {

    /**
     * 2.题目描述
     * 给你一个字符串 s，字符串 s 首尾相连成一个环形，请你在环中找出 'l'、'o'、'x' 字符都恰好出现了偶数次最长子字符串的长度。
     *
     * 输入描述
     * 输入是一串小写的字母组成的字符串
     *
     * 输出描述
     * 输出是一个整数
     *
     * 1 ≤ s.length ≤ 5 * 10^5
     *  s只包含小写英文字母
     *
     * 题目解析
     * 首先，我们需要统计字符串 s 中 'l'、'o'、'x' 字符的出现次数。
     * 然后，我们需要找到满足条件的最长子字符串。我们可以使用滑动窗口的方法，从左到右遍历字符串 s，同时维护一个窗口，使得窗口内的 'l'、'o'、'x' 字符出现次数都是偶数。当窗口内满足条件时，更新最长子字符串的长度。
     * 最后，输出最长子字符串的长度。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(getResult(input));
    }

    public static int getResult(String s) {
        // status 是一个 3 位二进制数，用于表示 'l'、'o' 和 'x' 的出现次数的奇偶性。例如，0b100 表示 'l' 出现了奇数次，而其他两个字符出现了偶数次
        int status = 0b000;
        // map 是一个 LinkedList 数组，用于存储每种状态第一次出现的索引
        LinkedList<Integer>[] map = new LinkedList[8];
        for (int i = 0; i < 8; i++) {
            map[i] = new LinkedList<>();
        }
        map[0].add(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length() * 2; i++) {
            // 通过模运算处理环形结构，将 i 映射到原始字符串的索引
            char c = s.charAt(i % s.length());
            switch (c) {
                case 'l':
                    // 分别用来切换 'l'、'o' 和 'x' 的出现次数的奇偶性。如果字符出现了奇数次，则状态位翻转
                    status ^= 0b100;
                    break;
                case 'o':
                    status ^= 0b010;
                    break;
                case 'x':
                    status ^= 0b001;
                    break;
            }

            // 当 i 小于 s.length() 时，将当前索引 i 加入对应的 map 中
            if (i < s.length()) {
                map[status].add(i);
            }

            // 在 map[status] 中找到最早出现的索引，检查从这个索引到当前索引 i 的子串长度是否大于 s.length，如果是，则更新 maxLen
            while (!map[status].isEmpty()) {
                int earliest = map[status].getFirst();
                if (i - earliest > s.length()) {
                    map[status].removeFirst();
                } else {
                    maxLen = Math.max(maxLen, i - earliest);
                    break;
                }
            }
        }

        return maxLen;
    }



}
