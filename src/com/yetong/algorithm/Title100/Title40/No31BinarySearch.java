package com.yetong.algorithm.Title100.Title40;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 二分茶轴
 */
public class No31BinarySearch {
    public static void main(String[] args) {
        int arr[] = {8, 6, 1, 9, 5, 7, 3, 12, 11, 49, 15};
        //System.out.println(new No31BinarySearch().BinarySearch(arr, 3));
        new No31BinarySearch().insertSort(arr);
    }

    public int BinarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int half = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            if (target > arr[half]) {
                half = (arr.length + half) / 2;
            } else if (target < arr[half]) {
                half = half / 2;
            } else return target;
        }
        return -1;
    }

    public int[] insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}
