package com.yetong.algorithm.Title100.Title40;

/**
 * 搜索插入位置
 */
public class No33SearchInsert {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] numList, int target) {
        int n = numList.length - 1;
        if (target <= numList[0]) {
            return 0;
        }
        if (target > numList[n]) {
            return n + 1;
        }
        int left = 0;
        int right = n;
        int mid = left + (right - left) / 2;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (target == numList[mid]) {
                return mid;
            } else if (target > numList[mid]) {
                if (target < numList[mid + 1]) {
                    return mid + 1;
                }
                left = mid + 1;
            } else {
                if (target > numList[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 在进入最后的一次循环之前数组只会剩下一个元素或者2个元素那么在进行循环之后无论是什么情况最后的下标都是left
     * @param numList
     * @param target
     * @return
     */
    public int searchInsertYouHua(int[] numList, int target) {
        int left = 0;
        int right = numList.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == numList[mid]) {
                return mid;
            } else if (target > numList[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
