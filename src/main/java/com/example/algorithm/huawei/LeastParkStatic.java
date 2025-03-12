package com.example.algorithm.huawei;

import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/8/19 01:44
 * @Version 1.0
 * 停车场车辆统计
 */
public class LeastParkStatic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * 首先移除输入字符串中的所有逗号
         * 然后将所有出现的 "111" 替换为 "x"
         * 接着将所有出现的 "11" 替换为 "x"
         * 最后将所有剩下的 "1" 替换为 "x"
         */
        String str =
                sc.nextLine()
                        .replaceAll(",", "")
                        .replaceAll("111", "x")
                        .replaceAll("11", "x")
                        .replaceAll("1", "x");

        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}

