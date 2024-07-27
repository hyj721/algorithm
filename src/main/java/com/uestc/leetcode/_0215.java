package com.uestc.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: hyj721
 * @create: 2024-07-27 10:46
 * @description: <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">...</a>
 **/
public class _0215 {
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(k);
    //     for (int i = 0; i < k; i++) {
    //         pq.add(nums[k]);
    //     }
    //     for (int i = k; i < nums.length; i++) {
    //         Integer peek = pq.peek();
    //         if (nums[k] > peek) {
    //             pq.remove();
    //             pq.add(nums[k]);
    //         }
    //     }
    //     return pq.peek();
    // }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public int quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) {
            return nums[l];
        }
        int i = l - 1, j = r + 1, x = nums[l + r >> 1];
        while (i < j) {
            do {
                i++;
            } while (nums[i] > x);
            do {
                j--;
            } while (nums[j] < x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int leftCount = j - l + 1;
        if (k <= leftCount) {
            return quickSort(nums, l, j, k);
        } else {
            return quickSort(nums, j + 1, r, k - leftCount);
        }
    }
}
