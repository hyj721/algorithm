package com.uestc.leetcode;

import java.util.LinkedList;

/**
 * @author: hyj721
 * @create: 2024-07-27 18:55
 * @description: <a href="https://leetcode.cn/problems/design-linked-list/">...</a>
 **/
public class _0707 {
    class MyLinkedList {

        private LinkedList<Integer> linkedList;

        public MyLinkedList() {
            this.linkedList = new LinkedList<>();
        }

        public int get(int index) {
            if (inValidIndex(index)) {
                return -1;
            }
            return linkedList.get(index);
        }

        public void addAtHead(int val) {
            linkedList.add(0, val);
        }

        public void addAtTail(int val) {
            linkedList.add(linkedList.size(), val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > linkedList.size()) {
                return;
            }
            linkedList.add(index, val);
        }

        public void deleteAtIndex(int index) {
            if (inValidIndex(index)) {
                return;
            }
            linkedList.remove(index);
        }

        private boolean inValidIndex(int index) {
            return index < 0 || index >= linkedList.size();
        }
    }
}
