package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-04 09:33
 * @description: <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">...</a>
 **/
public class _0160 {
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthOfA = getLength(headA);
            int lengthOfB = getLength(headB);
            // 确保前者的长度是更长的
            if (lengthOfA < lengthOfB) {
                return getIntersectionNode(headB, headA);
            }
            int diff = lengthOfA - lengthOfB;
            while (diff-- != 0) {
                headA = headA.next;
            }
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }

        private int getLength(ListNode head) {
            ListNode cur = new ListNode(-1);
            cur.next = head;
            int res = 0;
            while (cur.next != null) {
                cur = cur.next;
                res++;
            }
            return res;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}