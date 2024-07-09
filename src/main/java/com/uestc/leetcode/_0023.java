package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-09 09:33
 * @description: <a href="https://leetcode.cn/problems/merge-k-sorted-lists/">...</a>
 **/
public class _0023 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return mergeHelper(lists, 0, lists.length - 1);
        }

        public ListNode mergeHelper(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }
            int mid = left + right >> 1;
            ListNode lhs = mergeHelper(lists, left, mid);
            ListNode rhs = mergeHelper(lists, mid + 1, right);
            return mergeTwoLists(lhs, rhs);
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
