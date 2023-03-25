package com.yetong.algorithm.Title100.Title40;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 缺失的第一个正数
 */
public class No40FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {-1, -44, -22, 1};
        No40FirstMissingPositive no40 = new No40FirstMissingPositive();
        System.out.println(no40.firstMissingPositive(arr));
    }

    /**
     * 原地哈希
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        for (int i = 1; i < nums.length; i++) {
            if (!integers.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
