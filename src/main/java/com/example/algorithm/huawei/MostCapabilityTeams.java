package com.example.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/8/19 01:53
 * @Version 1.0
 * 求最多可以派出多少支团队
 */
public class MostCapabilityTeams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        int[] capabilities = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int miniCapability = Integer.parseInt(scanner.nextLine());



    }

    public static int getResult(int n, int[] capabilities, int miniCap) {
        //升序
        Arrays.sort(capabilities);
        
        int l = 0;
        int r = n -1;
        int ans = 0;

        //单人组队
        while (l <= r && capabilities[r] > miniCap) {
            ans++;
            r--;
        }

        //双人组队
        while (l < r) {
            int sum = capabilities[l] + capabilities[r];
            //如果两个人能力之和大于阈值，则组队
            if (sum >= miniCap) {
                ans++;
                l++;
                r--;
            } else {
                // 否则将能力低的人剔除，换下一个能力高的人
                l++;
            }
        }

        return ans;
    }
}
