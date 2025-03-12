package com.example.algorithm.base;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/13 16:07
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        quickSort(arr, 0, arr.length - 1);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取分区点的索引
            int pivotIndex = partition(arr, low, high);
            // 对分区点左边的子数组进行快速排序
            quickSort(arr, low, pivotIndex - 1);
            // 对分区点右边的子数组进行快速排序
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准值
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将基准值放到正确的位置上
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}
