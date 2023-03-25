package com.yetong.algorithm.Title100.Title20;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 三数和接近
 */
public class No16ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] numList, int target) {
        Arrays.sort(numList);
        int res = numList[0] + numList[1] + numList[2];
        for (int k = 0; k < numList.length - 2; k++) {
            int i = k + 1;
            int j = numList.length - 1;
            while (i < j) {
                int sum = numList[k] + numList[j] + numList[i];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
