package com.example.algorithm.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Version 1.0
 * 密码输入检测
 * 密码安全要求如下：
 * 1.密码长度 ≥ 8
 * 2.密码至少需要包含1个大写字母
 * 3.密码至少需要包含1个小写字母
 * 4.密码至少需要包含1个数字
 * 5.密码至少需要包含1个字母和数字以外的非空白特殊字符
 * 注意空串退格后仍然为空串，且用户输入的字符串不包含'<'字符和空白字符
 *
 * <p>
 * 题解：
 * 使用压栈，弹栈来操作
 * 最后统计栈中满足：所有字符数量 >= 8 && 小写字母数量>=1 && 大写字母数量 >=1 && 数字数量>=1 && 非字母数字空白字符数量>=1,
 * 若满足，则将栈的字符拼接为字符串后再追加"true",否则追加"false"
 */
public class PasswordInputDetect {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        int upper = 0;
        int lower = 0;
        int number = 0;
        int non_letter_number = 0;

        StringBuilder password = new StringBuilder();
        for (Character c : stack) {
            password.append(c);

            if (c >= 'a' && c <= 'z') {
                lower++;
            } else if (c >= 'A' && c <= 'Z') {
                upper++;
            } else if (c >= '0' && c <= '9') {
                number++;
            } else {
                non_letter_number++;
            }
        }

        if (password.length() >= 8
                && lower >= 1
                && upper >= 1
                && number >= 1
                && non_letter_number >= 1) {
            password.append(",true");
        } else {
            password.append(",false");
        }

        System.out.println(password);
    }
}

