package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-07 09:12
 * @description: <a href="https://leetcode.cn/problems/add-two-numbers/">...</a>
 **/
public class _0002 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            int q = 0;
            ListNode cur = dummy;
            while (l1 != null || l2 != null) {
                int sum = 0;
                if (l1 != null) {
                    sum += l1.val;
                }
                if (l2 != null) {
                    sum += l2.val;
                }
                sum += q;
                int bit = sum % 10;
                q = sum / 10;
                cur.next = new ListNode(bit);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            // 考虑最后的进位
            if (q != 0) {
                cur.next = new ListNode(q);
            }
            return dummy.next;
        }
    }
}
