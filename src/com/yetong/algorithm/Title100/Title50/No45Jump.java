package com.yetong.algorithm.Title100.Title50;

public class No45Jump {

    public static void main(String[] args) {
        int arr[] = {2, 4, 3, 6, 1, 3, 3, 7};
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {

        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
