package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-06 22:02
 * @description: <a href="https://leetcode.cn/problems/linked-list-cycle/">...</a>
 **/
public class _0141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
