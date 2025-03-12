package com.example.algorithm.huawei;

import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/8/13 18:38
 * @Version 1.0
 */
public class LookForSeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine().toCharArray()));
    }

    public static int getResult(char[] desk) {
        int ans = 0;

        for (int i = 0; i < desk.length; i++) {
            if (desk[i] == '0') {
                // 当前位置在最左边或当前位置的左边位是'0'
                boolean isLeftEmpty = i == 0 || desk[i - 1] == '0';
                // 当前位置在最右边 或 当前位置的右边位是'0'
                boolean isRightEmpty = i == desk.length - 1 || desk[i + 1] == '0';
                if (isLeftEmpty && isRightEmpty) {
                    ans++;
                    desk[i] = '1';
                    // 当前位若赋值为1了，下一位绝对不能坐了，则可以直接跳过
                    i++;
                }
            }
        }

        return ans;
    }
}
