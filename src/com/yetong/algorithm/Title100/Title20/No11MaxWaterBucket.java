package com.yetong.algorithm.Title100.Title20;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No11MaxWaterBucket {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxWater(arr));
        System.out.println(youHuaMaxWater(arr));
    }

    public static int maxWater(int[] arr) {
        int max = 0;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    list.add(j);
                    if (list.size() >= 2) {
                        max = Math.max(max, (list.get(list.size() - 1) - list.get(0)) * arr[i]);
                    }
                }
            }
            list.clear();
        }
        return max;
    }

    //双指针移动 时间复杂度on
    public static int youHuaMaxWater(int arr[]) {
        //起始
        int head = 0;
        //尾部
        int end = arr.length - 1;
        int res = 0;
        while (head < end) {
            res = Math.max(res, Math.min(arr[head], arr[end]) * (end - head));
            if (arr[head] < arr[end]) {
                head++;
            } else {
                end--;
            }
        }
        return res;
    }

    public static int youhua(int arr[]) {
        int head = 0;
        int end = arr.length - 1;
        int res = 0;
        while (head < end) {
            res = Math.max(res, Math.min(arr[head], arr[end]) * (end - head));
            if (arr[head] < arr[end]) {
                head++;
            }else {
                end--;
            }
        }
        return res;
    }
}
