package com.example.algorithm.bytedance;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/23 21:44
 * @Version 1.0
 * <p>
 * 方法三：双指针
 * 动态规划的做法中，需要维护两个数组 leftMax 和 rightMax，因此空间复杂度是 O(n)。是否可以将空间复杂度降到 O(1)？
 * 注意到下标 i 处能接的雨水量由 leftMax[i] 和 rightMax[i] 中的最小值决定。由于数组 leftMax 是从左往右计算，数组 rightMax 是从右往左计
 * 算，因此可以使用双指针和两个变量代替两个数组。
 * 维护两个指针 left 和 right，以及两个变量 leftMax 和 rightMax，初始时 left=0,right=n−1,leftMax=0,rightMax=0。指针 left 只会向右
 * 移动，指针 right 只会向左移动，在移动指针的过程中维护两个变量 leftMax 和 rightMax 的值。
 * <p>
 * 当两个指针没有相遇时，进行如下操作：
 * 使用 height[left] 和 height[right] 的值更新 leftMax 和 rightMax 的值；
 * 如果 height[left]<height[right]，则必有 leftMax<rightMax，下标 left 处能接的雨水量等于 leftMax−height[left]，将下标 left 处能
 * 接的雨水量加到能接的雨水总量，然后将 left 加 1（即向右移动一位）；
 * 如果 height[left]≥height[right]，则必有 leftMax≥rightMax，下标 right 处能接的雨水量等于 rightMax−height[right]，将下标 right
 * 处能接的雨水量加到能接的雨水总量，然后将 right 减 1（即向左移动一位）。
 * 当两个指针相遇时，即可得到能接的雨水总量。
 * 下面用一个例子 height=[0,1,0,2,1,0,1,3,2,1,2,1] 来帮助读者理解双指针的做法。
 */
public class 接雨水 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = trap(height);
        System.out.println(res);
    }

    public static int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
