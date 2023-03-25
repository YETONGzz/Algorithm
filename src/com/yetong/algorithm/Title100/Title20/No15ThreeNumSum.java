package com.yetong.algorithm.Title100.Title20;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求三数之和
 */
public class No15ThreeNumSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] numList) {
        List<List<Integer>> res = new ArrayList<>();
        if (numList.length < 3) {
            return res;
        }
        Arrays.sort(numList);
        for (int k = 0; k < numList.length - 2; k++) {
            int i = k + 1;
            int j = numList.length - 1;
            int sum = 0 - numList[k];
            if (numList[k] > 0) {
                break;
            }
            //如果在k大于0的情况下两值相等那么k向后移动
            if (k > 0 && numList[k] == numList[k - 1]) {
                continue;
            }
            //当左边的指针小于右边的指针时开始进行扫描
            while (i < j) {
                if (i < j && numList[i] + numList[j] == sum) {
                    res.add(Arrays.asList(numList[k], numList[i], numList[j]));
                    //当i与i+1相等时i向后移动这样可以避免重复的情况
                    while (i < j && numList[i] == numList[i + 1]) {
                        i++;
                    }
                    //当j与j-1相等时j向前移动这样可以避免重复的情况
                    while (i < j && numList[j] == numList[i - 1]) {
                        j++;
                    }
                    //无论什么情况两个指针都要移动继续去判断一下个情况
                    i++;
                    j--;
                    //如果小于sum那么i向右移动
                } else if (i < j && numList[i] + numList[j] < sum) {
                    i++;
                    //否则j向左移动
                } else {
                    j--;
                }
            }
        }
        return res;
    }


    public List<List<Integer>> threeNum(int[] arr) {
        if (arr.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            int sum = arr[i];
            if (arr[i] > 0) {
                break;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            while (left < right) {
                if (arr[left] + arr[right] + sum == 0) {
                    res.add(Arrays.asList(i, left, right));

                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }

                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (arr[left] + arr[right] + sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

}
