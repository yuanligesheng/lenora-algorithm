package com.example.algorithm.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/2 22:06
 * @Version 1.0
 * 单词接龙
 * 解析：
 * 1.先去除第k个单词，单词串chain的第一个部分
 * 2.按照前缀首字母，将剩余单词进行分类，统计为prefix，其中prefix[c]表示c首字母的单词集合
 * 循环如下逻辑
 * （1）找到单词串chain的尾字母c，然后找到prefix[c]中最高优先级的单词word，优先级比较如下：
 * 当存在多个首字母相同的单词时，取长度最长的单词，如果长度也相等，则取字典序最小的单词
 * （2）将word从prefix[c]集合中取出，拼接到chain后面
 * 得到循环到chain的尾字母c，在prefix中找不到对应单词为止
 * 此时chain即为题解。
 */
public class test2 {

    static int k;
    static int n;
    static ArrayList<String> words;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(sc.next());
        }
        System.out.println(solution());
    }

    public static String solution() {
        ArrayList<String> chain = new ArrayList<>();
        chain.add(words.remove(k));

        HashMap<Character, LinkedList<String>> prefix = new HashMap<>();
        for (String word : words) {
            char c = word.charAt(0);
            prefix.putIfAbsent(c, new LinkedList<>());
            prefix.get(c).add(word);
        }

        for (Character c : prefix.keySet()) {
            prefix.get(c).sort((a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        }

        while (true) {
            String word = chain.get(chain.size() - 1);
            char tail = word.charAt(word.length() - 1);

            if (!prefix.containsKey(tail) || prefix.get(tail).isEmpty()) {
                break;
            }

            chain.add(prefix.get(tail).removeFirst());
        }
        return String.join("", chain);
    }
}

