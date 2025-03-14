package com.example.algorithm.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author black mamba
 * @Date 2025/3/14 23:31
 * @Version 1.0
 */
public class ListUtil {
    public static void main(String[] args) {

        // 打印list数组中每个元素，并以逗号隔开
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(String.join(", ", list));
    }
}
