package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-24 10:03
 * @description: <a href="https://leetcode.cn/problems/remove-linked-list-elements/">...</a> 代码随想录 「链表-1.移除链表元素」
 **/
public class _0203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
