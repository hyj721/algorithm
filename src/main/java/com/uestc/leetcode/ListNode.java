package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-08 09:38
 * @description: 单向链表节点
 **/
public class ListNode {
    int val; // 节点的值
    ListNode next; // 指向下一个节点的引用

    // 无参构造函数
    ListNode() {}

    // 带一个参数的构造函数
    ListNode(int val) {
        this.val = val;
    }

    // 带两个参数的构造函数
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
