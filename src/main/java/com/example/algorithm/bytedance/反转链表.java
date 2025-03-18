package com.example.algorithm.bytedance;

/**
 * @Author Wang Haoyu
 * @Date 2024/9/23 22:01
 * @Version 1.0
 */
public class 反转链表 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
