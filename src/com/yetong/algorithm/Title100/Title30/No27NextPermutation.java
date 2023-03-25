package com.yetong.algorithm.Title100.Title30;

import java.util.Arrays;

/**
 * 整数数组的下一个排列
 */
public class No27NextPermutation {

    public static void main(String[] args) {
        int[] a = {3,2,1};
        new No27NextPermutation().nextPermutation(a,0);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public void nextPermutation(int[] numList, int n) {
        int length = numList.length;
        int j = numList.length - 2;
        while (j >= 0 && numList[j] > numList[j + 1]) {
            j--;
        }

        if(j>=0){
            int k = length - 1;
            while (k > j && numList[k] <= numList[j]) {
                k--;
            }
            swap(numList, j, k);
        }

        for (int i = j + 1, m = length - 1; i < m; i++, m--) {
            swap(numList, i, m);
        }
    }


    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        int j = n - 2;
        while (j >= 0 && nums[j] >= nums[j + 1]) {
            j--;
        }

        if (j >= 0) {
            int k = n - 1;
            while (k > j && nums[k] <= nums[j]) {
                k--;
            }
            swap(nums, j, k);
        }
        // reverse [j + 1, n - 1]
        for (int i = j + 1, k = n - 1; i < k; i++, k--) {
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
