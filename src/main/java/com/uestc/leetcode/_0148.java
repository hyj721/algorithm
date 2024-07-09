package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-08 10:15
 * @description: <a href="https://leetcode.cn/problems/sort-list/">...</a>
 **/
public class _0148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode middle = getMiddle(head);
            ListNode rightBegin = middle.next;
            // 切断中间
            middle.next = null;
            // 分别排序
            ListNode left = sortList(head);
            ListNode right = sortList(rightBegin);
            return mergeTwoLists(left, right);
        }

        public ListNode getMiddle(ListNode head) {
            // 如果正常同步开始往前走，那么 slow 走太多了（可以自己画个图看看），于是让 fast 先走，就可以保证划分的大小，避免死循环
            ListNode slow = head;
            ListNode fast = head.next.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            cur.next = list1 == null ? list2 : list1;
            return dummy.next;
        }
    }
}
