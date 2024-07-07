package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-07 09:27
 * @description: <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">...</a>
 **/
public class _0019 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1, head);
            ListNode slow = dummy;
            ListNode fast = dummy;
            while (n-- != 0) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
