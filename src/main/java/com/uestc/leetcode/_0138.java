package com.uestc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hyj721
 * @create: 2024-07-08 09:59
 * @description: https://leetcode.cn/problems/copy-list-with-random-pointer/
 **/
public class _0138 {
    class Solution {
        public Node copyRandomList(Node head) {
            Node cur = head;
            // 建立映射关系
            Map<Node, Node> map = new HashMap<>();
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }

            // 准备第二次遍历
            cur = head;
            while (cur != null) {
                Node mirror = map.get(cur);
                mirror.next = map.get(cur.next);
                mirror.random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);

        }
    }
}
