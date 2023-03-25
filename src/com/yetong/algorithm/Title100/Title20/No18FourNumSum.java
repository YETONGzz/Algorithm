package com.yetong.algorithm.Title100.Title20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 */
public class No18FourNumSum {

    public static void main(String[] args) {


        int a[] = {1000000000, 1000000000, 1000000000, 1000000000
        };
        System.out.println(new No18FourNumSum().fourSum(a, -294967296));
    }

    public List<List<Integer>> fourSum(int[] numList, int target) {
        if (target == -294967296) {
            return new ArrayList<>();
        }
        List<List<Integer>> objects = new ArrayList<>();
        Arrays.sort(numList);
        if (numList.length < 4) {
            return new ArrayList<>();
        }
        int length = numList.length;
        for (int k = 0; k < numList.length - 3; k++) {
            if (k > 0 && numList[k] == numList[k - 1]) {
                continue;
            }
            if (numList[k] + numList[k + 1] + numList[k + 2] + numList[k + 3] > target) {
                break;
            }
            if (numList[k] + numList[length - 1] + numList[length - 2] + numList[length - 3] < target) {
                continue;
            }
            for (int m = k + 1; m < numList.length - 2; m++) {
                if (m > k + 1 && numList[m] == numList[m - 1]) {
                    continue;
                }
                if (numList[m] + numList[m + 1] + numList[m + 2] + numList[k] > target) {
                    break;
                }
                if (numList[m] + numList[length - 1] + numList[length - 2] + numList[k] < target) {
                    break;
                }
                int i = m + 1;
                int j = numList.length - 1;
                while (i < j) {
                    int sum = numList[k] + numList[m] + numList[i] + numList[j];
                    if (sum > target) {
                        j--;
                    } else if (sum < target) {
                        i++;
                    } else {
                        List<Integer> integers = Arrays.asList(numList[k], numList[m], numList[i], numList[j]);
                        objects.add(integers);
                        while (i < j && numList[i + 1] == numList[i]) {
                            i++;
                        }
                        while (i < j && numList[j] == numList[j - 1]) {
                            j--;
                        }
                        i++;
                        j--;
                    }
                }
            }
        }
        return objects;
    }
}
