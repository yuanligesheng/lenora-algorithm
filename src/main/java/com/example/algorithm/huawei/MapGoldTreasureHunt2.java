package com.example.algorithm.huawei;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/1 16:23
 * @Version 1.0
 * 17.小华地图寻宝
 * 解法二：广度有线搜索
 */
public class MapGoldTreasureHunt2 {
    static int m;
    static int n;
    static int k;

    // 记录已访问过的位置，避免重复统计
    static HashSet<Integer> visited = new HashSet<>();

    // 上下左右偏移量
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 数位和数组
    static int[] digitSums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        digitSum(Math.max(m, n));

        if (m == 0 || n == 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }

    public static int bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);

        // 由于k>=0,因此出发点(0,0)肯定可以访问，且有黄金
        int ans = 1;
        visited.add(0);

        while (queue.size() > 0) {
            int pos = queue.removeFirst();

            int x = pos / n;
            int y = pos % n;

            // 遍历当前位置的上下左右四个方向的新位置
            for (int[] offset : offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];

                // 新位置越界，则无法访问
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;

                // 新位置的横坐标、纵坐标数位和之和超过k，则无法访问
                if (digitSums[newX] + digitSums[newY] > k) continue;

                // 新位置已访问过，则不能再访问
                int newPos = newX * n + newY;
                if (visited.contains(newPos)) continue;

                // 否则，可以进入新位置，且获得黄金
                ans++;
                visited.add(newPos);
                queue.addLast(newPos);
            }
        }

        return ans;
    }

    // 该方法用于求解 0 ~ maxSize - 1 各个数对应的数位和，提前计算好，避免后期重复计算某个数的数位和
    public static void digitSum(int maxSize) {
        // digitSums数组的索引是原始数，值是原始数对应的数位和
        digitSums = new int[maxSize];

        for (int i = 0; i < maxSize; i++) {
            int num = i;
            while (num > 0) {
                digitSums[i] += num % 10;
                num /= 10;
            }
        }
    }
}
