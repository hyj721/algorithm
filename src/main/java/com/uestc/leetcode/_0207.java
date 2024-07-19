package com.uestc.leetcode;

import java.util.*;

/**
 * @author: hyj721
 * @create: 2024-07-19 19:09
 * @description: <a href="https://leetcode.cn/problems/course-schedule/">...</a>
 **/
public class _0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // prerequisites[a, b]：b->a
        // 入度数组，记录每个课「直接」前置课程有多少
        // map，记录学习了当前课程之后，可以影响到的后续直接课程
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            if (map.containsKey(prerequisite[1])) {
                map.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                map.put(prerequisite[1], list);
            }
        }
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.addLast(i);
                count++;
            }
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i  = 0; i < size; i++) {
                Integer removed = deque.removeFirst();
                List<Integer> list = map.get(removed);
                if (list != null && !list.isEmpty()) {
                    for (Integer item : list) {
                        if (--inDegree[item] == 0) {
                            deque.addLast(item);
                            count++;
                        }
                    }
                }
            }
        }
        return count == numCourses;
    }
}
