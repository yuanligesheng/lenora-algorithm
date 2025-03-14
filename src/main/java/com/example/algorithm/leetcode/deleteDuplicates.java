package com.example.algorithm.leetcode;

/**
 * leetcode-83:删除排序链表中的重复元素
 *
 * 同removeDuplicates，删除有序数组中的重复项
 *
 * @Author Wang Haoyu
 * @Date 2025/3/13 01:04
 * @Version 1.0
 */
public class deleteDuplicates {

    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast;
                // slow++;
                slow = fast.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
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
