package com.yetong.algorithm.Title100.Title30;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class No23removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new No23removeDuplicates().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] numList) {
        int length = 0;
        int i = 0;
        int j = 1;
        if (numList.length == 1) {
            return numList.length;
        }
        while (true) {
            j = i + 1;
            if (numList[i] == numList[j]) {
                for (int k = i; k < numList.length - 1; k++) {
                    numList[k] = numList[k + 1];
                }
            } else {
                i++;
                j = i + 1;
            }
            if (numList[i] == numList[numList.length - 1]) {
                length = i + 1;
                break;
            }
        }
        List<Integer> ints = Arrays.stream(numList).boxed().collect(Collectors.toList());
        ints.forEach(System.out::println);
        return length;
    }

    //采用双指针的方式
    public int removeDuplicatesYouHua(int[] numList) {
        if (numList.length == 1) {
            return numList.length;
        }
        int front = 0;
        int after = 1;
        for (int i = 0; i < numList.length; i++) {
            if (numList[front] == numList[after]) {
                after++;
            } else {
                numList[front + 1] = numList[after];
                front++;
                after++;
            }
        }
        return front + 1;
    }


}
