package com.yetong.algorithm.Title100.Title30;

/**
 * 搜索旋转数组
 */
public class No29SearchArr {
    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        int b = 0;
        System.out.println(new No29SearchArr().search(a, b));
    }

    public int search(int[] numList, int target) {
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < numList.length; i++) {
            res = (flag = numList[i]==target) ? i : -1;
            if (flag) return res;
        }
        return res;
    }
}
