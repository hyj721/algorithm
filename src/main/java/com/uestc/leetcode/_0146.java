package com.uestc.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: hyj721
 * @create: 2024-07-09 09:57
 * @description: <a href="https://leetcode.cn/problems/lru-cache/">...</a>
 **/
public class _0146 {
    class LRUCache {

        private Map<Integer, Integer> map;
        private int size;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>();
            size = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            makeRecent(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            // 包含该 key
            if (map.containsKey(key)) {
                map.put(key, value);
                makeRecent(key);
                return;
            }
            // 不包含这个 key
            // 如果已经满了
            if (map.size() == size) {
                Integer oldestKey = map.keySet().iterator().next();
                map.remove(oldestKey);
                map.put(key, value);
                return;
            }

            // 如果还没有满
            map.put(key, value);


        }

        private void makeRecent(int key) {
            Integer removed = map.remove(key);
            map.put(key, removed);
        }
    }
}