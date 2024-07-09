package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-08 09:19
 * @description: <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">...</a>
 **/
public class _0025 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy;
            ListNode begin = head;
            ListNode end = dummy;
            while (true) {
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                // 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
                if (end == null) {
                    break;
                }
                ListNode tmp = end.next;
                // 先截断
                end.next = null;
                // 反转链表的头部作为 pre.next
                pre.next = reverseList(begin);

                // 原来的 begin 经过反转后到尾部了，现在吧 pre、end 都指向尾部
                pre = begin;
                end = begin;
                // 把 begin 指向新的头部
                begin = tmp;

                // 重新连接
                end.next = begin;
            }
            return dummy.next;
        }

        private ListNode reverseList(ListNode head) {
            ListNode pre = null; // 初始化前一个节点为 null
            ListNode cur = head; // 当前节点初始化为头节点

            while (cur != null) { // 遍历链表直到当前节点为 null
                ListNode tmp = cur.next; // 临时保存下一个节点
                cur.next = pre; // 将当前节点的 next 指向前一个节点，实现反转
                pre = cur; // 前一个节点前进到当前节点
                cur = tmp; // 当前节点前进到下一个节点
            }

            return pre; // 返回反转后的新头节点
        }
    }
}
