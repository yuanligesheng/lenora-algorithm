package com.example.algorithm.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/8/19 01:10
 * @Version 1.0
 * 内存冷热标记
 */
public class MemoryHotColdMark {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //存入哈希表<num, value>,num为内存也框号，value为计算的出现次数
        HashMap<Integer, Integer> cnts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        int threshold = sc.nextInt();
        //移除键对应的值小于 threshold的
        cnts.keySet().removeIf(num -> cnts.get(num) < threshold);
        System.out.println(cnts.size());
        cnts.entrySet().stream()
                .sorted(
                        (a, b) ->
                                a.getValue() - b.getValue() != 0
                                        ? b.getValue() - a.getValue()
                                        : a.getKey() - b.getKey())
                .forEach(a -> System.out.println(a.getKey()));
    }
}

