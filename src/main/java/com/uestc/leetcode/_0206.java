package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-06 21:37
 * @description: <a href="https://leetcode.cn/problems/reverse-linked-list/">...</a>
 **/
public class _0206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}
