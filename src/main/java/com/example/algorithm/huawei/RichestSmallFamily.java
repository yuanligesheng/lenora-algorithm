package com.example.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/8/13 19:11
 * @Version 1.0
 * 最富裕的小家庭
 *
 */
public class RichestSmallFamily {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            // 这里wealth长度定义为n+1，是为了让wealth数组索引对应成员编号 1~N
            long[] wealth = new long[n + 1];
            long[] family = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                wealth[i] = sc.nextInt();
                family[i] = wealth[i];
            }

            for (int i = 0; i < n - 1; i++) {
                int fa = sc.nextInt();
                int ch = sc.nextInt();
                family[fa] += wealth[ch];
            }

            System.out.println(Arrays.stream(family).max().orElse(0));
        }
    }
