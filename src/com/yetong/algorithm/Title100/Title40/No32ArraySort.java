package com.yetong.algorithm.Title100.Title40;

/**
 * 数组的多种排序
 */
public class No32ArraySort {
    public static void main(String[] args) {
        No32ArraySort sort = new No32ArraySort();
        int[] arr = {12, 11, 6, 5};
        //sort.insertSort(arr);
        //sort.shellSort(arr);
        sort.Merge_Sort(arr, 0, arr.length - 1);
    }

    /**
     * 插入排序
     * 将已经排好序的子集元素序列和待排序的元素比较
     */
    public void insertSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            //temp 用来记录待排序的元素
            int temp = arr[i];
            //从待排序的元素的前面的元素开始依次和待排序元素进行比较
            int j = i - 1;
            //如果大于待排序元素那么将元素一次插入到待排序元素的下标位置和嗲排序元素之前的位置
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            //直到元素不大于待排序元素或者已经找到起始位置了,那么将=待排序元素插入到不大于他的元素的下标加一的位置
            arr[j + 1] = temp;
        }
        soutArr(arr);
    }


    /**
     * 希尔排序 为插入排序的改进版
     */
    public void shellSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //获得希尔增量(也就是对数据分成多少组)
        int gap = arr.length >> 1;
        while (gap > 0) {
            //通过gap来控制每组之间的数据用插入排序来进行比较
            for (int i = gap; i < arr.length; i++) {
                //temp 用来记录一组中待排序的元素
                int temp = arr[i];
                //每组之中的待排序元素的前一个元素
                int j = i - gap;
                //与插入排序相同比较每组中的元素直到0为止或者不大于待排序元素为止
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                //每组之中直到元素不大于待排序元素或者已经找到起始位置了,那么将=待排序元素插入到不大于他的元素的下标加一的位置
                arr[j + gap] = temp;
            }
            //一次大循环结束后要缩减希尔增量
            gap >>= 1;
        }
        soutArr(arr);
    }


    /**
     * 归并排序
     */
    public int[] Merge_Sort(int[] arr, int start, int end) {
        //当start==end时，此时分组里只有一个元素，所以这是临界点
        if (start < end) {
            //分成左右两个分组，再进行递归
            int mid = (start + end) / 2;
            //左半边分组
            Merge_Sort(arr, start, mid);
            //右半边分组
            Merge_Sort(arr, mid + 1, end);
            //递归之后再归并归并一个大组
            Merge(arr, start, mid, end);
        }
        return arr;
    }

    /**
     * 合并方法
     */
    public void Merge(int[] arr, int start, int mid, int end) {
        //左边分组的起点i_start，终点i_end，也就是第一个有序序列
        int i_start = start;
        int i_end = mid;
        //右边分组的起点j_start，终点j_end，也就是第二个有序序列
        int j_start = mid + 1;
        int j_end = end;
        //额外空间初始化，数组长度为end-start+1
        int[] temp = new int[end - start + 1];
        int len = 0;
        //合并两个有序序列
        while (i_start <= i_end && j_start <= j_end) {
            //当arr[i_start]<arr[j_start]值时，将较小元素放入额外空间，反之一样
            if (arr[i_start] < arr[j_start]) {
                temp[len] = arr[i_start];
                len++;
                i_start++;
            } else {
                temp[len] = arr[j_start];
                len++;
                j_start++;
            }
            //temp[len++]=arr[i_start]<arr[j_start]?arr[i_start++]:arr[j_start++];
        }

        //i这个序列还有剩余元素
        while (i_start <= i_end) {
            temp[len] = arr[i_start];
            len++;
            i_start++;
        }
        //j这个序列还有剩余元素
        while (j_start <= j_end) {
            temp[len] = arr[j_start];
            len++;
            j_start++;
        }
        //辅助空间数据覆盖到原空间
        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }

    public void soutArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }


}
