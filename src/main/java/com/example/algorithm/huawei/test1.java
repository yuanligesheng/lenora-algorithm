package com.example.algorithm.huawei;

import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/2 23:34
 * @Version 1.0
 *
 * 最小的调整次数
 * 理解题意比较重要，都是从1-n依次顺序，要保证remove按1-n顺序：size（当前队列大小），isSorted（是否是已按顺序）、需要调整次数（count），
 * 是否tail不影响，出现head则次数count+1。
 * 	head +1，size=0：size+1，count不变；
 * 	head+1，size≠0：size+1，count +1；
 * 	tail+1：size+1，count不变；
 * 	remove+1：size-1，count不变。
 */
public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] cmds = new String[n * 2];
        for (int i = 0; i < n * 2; i++) {
            cmds[i] = sc.nextLine();
        }
        System.out.println(solution(cmds));
    }

    public static int solution(String[] cmds) {
        int size = 0;
        boolean isSorted = true;
        int count = 0;

        for (int i = 0; i < cmds.length; i++) {
            String cmd = cmds[i];
            if (cmd.startsWith("head add")) {
                if (size > 0 && isSorted) {
                    isSorted = false;
                }
                size++;
            } else if (cmd.startsWith("tail add")) {
                size++;
            } else {
                if (size == 0) {
                    continue;
                }
                if (!isSorted) {
                    count++;
                    isSorted = true;
                }
                size--;
            }
        }
        return count;
    }

}
