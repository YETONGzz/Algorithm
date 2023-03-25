package com.yetong.algorithm.Title100.Title30;

import java.util.Arrays;

//移除数组中与指定元素相等的元素
public class No24removeElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new No24removeElement().removeElement(nums, 2));
    }

    public int removeElement(int[] numList, int val) {
        Arrays.sort(numList);
        int k = 0;
        int start = 0;
        int x = 0;
        for (int i = 0; i < numList.length; i++) {
            if (numList[i] == val) {
                k++;
                start = i;
            }
        }
        x = start + 1 - k;
        int y = numList.length - start;
        for (int i = start; i < numList.length - 1; i++) {
            numList[x] = numList[x + k];
            x++;
        }
        return numList.length - k;
    }

    public int removeElement2(int[] numList, int val) {
        int k = 0;
        for (int i = 0; i < numList.length; i++) {
            if (numList[i] != val) {
                numList[k++] = val;
            }
        }

        return k;
    }

}
