package com.example.algorithm.base;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/23 22:29
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        bubbleSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
