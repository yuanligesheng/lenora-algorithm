package com.example.algorithm.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/8/27 11:58
 * @Version 1.0
 */
public class GameGroup游戏分组 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(getResult(arr));
    }

    public static int getResult(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        // dfs求10选5的去重组合，并将组合之和记录进res中，即res中记录的是所有可能性的5人小队实力值之和
        dfs(arr, 0, 0, 0, res);

        int sum = Arrays.stream(arr).reduce(Integer::sum).orElse(0);
        //某对示例是subsum，则另一对示例为sum-subsum，则两队示例差为：abs（（sum-subsum）-subsum），先求最小实力差
        return res.stream().map(subSum -> Math.abs(sum - 2 * subSum)).min((a, b) -> a - b).orElse(0);
    }

    // 求解去重组合
    // index: 当前遍历的起始位置，level: 当前已经选择的元素个数
    public static void dfs(int[] arr, int index,int level,int sum, ArrayList<Integer> res) {
        if (level == 5) {
            res.add(sum);
            return;
        }

        for (int i = index; i < 10; i++) {
            if (i > index && arr[i] == arr[i-1]) {
                continue;
            }
            dfs(arr, i + 1, level + 1, sum + arr[i],res);
        }
    }


}
