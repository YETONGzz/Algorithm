package com.yetong.algorithm.Title100.Title30;

/**
 * 在数组中查找元素的起始和结束位置
 */
public class No30SearchRange {

    public static void main(String[] args) {


        int[] arr = {5,7,7,8,8,10};

        new No30SearchRange().searchRangeYouHua(arr, 6);
    }

    public int[] searchRange(int[] numList, int target) {
        int[] res = {-1, -1};
        if (numList == null) {
            return res;
        }
        int k = 0;
        int start = 0;
        int end = numList.length - 1;
        for (int i = 0; i < numList.length; i++) {
            if (-1 == res[0]) {
                if (numList[start] > target) {
                    return res;
                } else if (numList[start] == target) {
                    res[0] = start;
                    k++;
                } else {
                    start++;
                }
            }
            if (-1 == res[1]) {
                if (numList[start] < target) {
                    return res;
                } else if (numList[end] == target) {
                    res[1] = end;
                    k++;
                } else if (numList[end] > target) {
                    end--;
                }
            }
            if (k == 2) {
                return res;
            }
        }
        return res;
    }

    public int[] searchRangeYouHua(int[] arr, int target) {
        int[] res = {-1, -1};
        int m = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int half = left+ ((right-left)>>1);
            if (arr[half] == target) {
                m =  half;
                break;
            } else if (arr[half] < target) {
                left = half + 1;
            } else{
                right = half -1;
            }
        }

        left = m;
        res[0] = left ;
        right = m;
        res[1] = right ;
        while (left - 1 >= 0 && arr[--left] == target) {
            res[0] = left ;
        }

        while (right + 1 < arr.length && arr[++right] == target) {
            res[1] = right ;
        }

        return res;
    }
}
