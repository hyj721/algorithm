package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-06 22:09
 * @description: <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">...</a>
 **/
public class _0142 {
    class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    break;
                }
            }
            // 说明这个链表没有环，直接返回 null
            if (fast == null || fast.next == null) {
                return null;
            }
            // 一个从开始出发，一个从相遇点开始出发，每次都各走一步，最后的相遇点就是环的入口
            ListNode meet = slow;
            ListNode cur = head;
            while (meet != cur) {
                cur = cur.next;
                meet = meet.next;
            }
            return cur;
        }
    }
}
