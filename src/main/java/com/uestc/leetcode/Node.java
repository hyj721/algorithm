package com.uestc.leetcode;

/**
 * 用于leetcode 第138题：随机链表的复制
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}