package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-06 21:42
 * @description: <a href="https://leetcode.cn/problems/palindrome-linked-list/">...</a>
 **/
public class _0234 {
    // class Solution {
    //     public boolean isPalindrome(ListNode head) {
    //         List<Integer> list = new ArrayList<>();
    //         while (head != null) {
    //             list.add(head.val);
    //             head = head.next;
    //         }
    //         int i = 0, j = list.size() - 1;
    //         while (i < j) {
    //             if (list.get(i) != list.get(j)) {
    //                 return false;
    //             }
    //             i++;
    //             j--;
    //         }
    //         return true;
    //     }
    // }
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // 此时 slow 为正中间（奇）或者 后半部分的开头

            // 反转后半部分
            ListNode right = reverseList(slow);
            while (head != null && right != null) {
                if (head.val != right.val) {
                    return false;
                }
                head = head.next;
                right = right.next;
            }
            return true;

        }

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
