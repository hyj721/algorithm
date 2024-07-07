package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-07 09:33
 * @description: <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">...</a>
 **/
public class _0024 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1, head);
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                ListNode tmp1 = cur.next;
                ListNode tmp2 = cur.next.next;
                cur.next = tmp2;
                tmp1.next = tmp2.next;
                tmp2.next = tmp1;

                cur = tmp1;
            }
            return dummy.next;
        }
    }
}
