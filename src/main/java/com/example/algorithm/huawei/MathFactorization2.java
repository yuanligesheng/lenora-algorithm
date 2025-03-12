package com.example.algorithm.huawei;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/1 16:38
 * @Version 1.0
 * 20.数的分解
 * 解法二：等差思想
 */
public class MathFactorization2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println(solution(n));
    }

    public static String solution(long n) {
        // 连续正整数序列长度m至少为2
        long m = 2;

        while (true) {
            // 初始序列  [1, 2, ..., m-1, m] 的序列和
            long Sn = (1 + m) * m / 2; // 等差数列求和公式：(首项 + 末项) * 项数 / 2

            // 初始序列的和 Sn
            // 目标序列的和 n

            // 初始序列之和不能大于目标序列之和，否则无解
            if (Sn > n) {
                break;
            }

            // 如果存在长度为m的“和n连续正整数序列”，那么必然 n - Sn 可以整除m
            if ((n - Sn) % m != 0) {
                m++;
                continue;
            }

            // 由于m从最小长度开始尝试，因此一旦找到，就是本题题解
            // 长度m，和n的连续正整数序列的首项计算
            long a1 = (n - Sn) / m + 1;

            StringJoiner sj = new StringJoiner("+", n + "=", "");
            for (int i = 0; i < m; i++) {
                sj.add(a1 + i + "");
            }

            return sj.toString();
        }

        return "N";
    }

}
