package com.example.algorithm.huawei;

import java.util.*;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/2 22:50
 * @Version 1.0
 */
public class test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getResult(arr[0], arr[1], arr[2], arr[3]));
    }

    public static int getResult(int s, int t, int a, int b) {
        int x = 0;
        int diff = t - s;
        while (true) {
            if ((diff - a * x) % b == 0 || (diff + a * x) % b == 0) {
                return Math.abs(x);
            }
            x++;
        }
    }

}

