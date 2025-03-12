package com.example.algorithm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/11 10:37
 * @Version 1.0
 */
public class PasswordDetect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String symbols = "$#@";
        String[] parts = input.split(",");
        for (String s : parts) {
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '<') {
                    if (list.isEmpty()) {
                        continue;
                    }
                    list.removeLast();
                } else {
                    list.addLast(c);
                }
            }

            int upper = 0;
            int lower = 0;
            int number = 0;
            int spect = 0;

            StringBuilder passwd = new StringBuilder();
            for (Character c : list) {
                passwd.append(c);

                if (c >= 'a' && c <= 'z') {
                    lower++;
                } else if (c >= 'A' && c <= 'Z') {
                    upper++;
                } else if (c >= '0' && c <= '9') {
                    number++;
                } else if (symbols.indexOf(c) != -1){
                    spect++;
                }
            }

            if (passwd.length() >= 8
                    && lower >= 1
                    && upper >= 1
                    && number >= 1
                    && spect >= 1
                    && passwd.length() >= 6
                    && passwd.length() <= 12) {
                System.out.println(passwd);
            }
        }



    }
}
