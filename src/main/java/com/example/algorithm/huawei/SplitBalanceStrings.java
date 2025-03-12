package com.example.algorithm.huawei;

import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/1 15:59
 * @Version 1.0
 */
public class SplitBalanceStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int countX = 0;
        int countY = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                countX++;
            } else {
                countY++;
            }
            if (countX == countY) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
