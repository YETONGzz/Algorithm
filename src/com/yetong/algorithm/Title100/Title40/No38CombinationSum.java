package com.yetong.algorithm.Title100.Title40;

import java.util.*;

/**
 * 组合总和
 */
public class No38CombinationSum {

    public static void main(String[] args) {
        No38CombinationSum no38 = new No38CombinationSum();
        int[] arr = {2, 3, 6, 7,5,1};
        System.out.println(no38.combinationSum(arr, 9));
    }

    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**
         * 因为在这里已经对数组进行了排序操作所以就避免了会出现重复的组合
         */
        Arrays.sort(candidates);
        if (null == candidates) {
            return null;
        }
        //单个组合的队列集合用来做回溯
        Deque<Integer> path = new ArrayDeque<>();
        //深度优先搜索
        dsf(candidates, target, 0, path);
        return resList;

    }


    public void dsf(int[] candidates, int target, int index, Deque<Integer> path) {
        //如果target等于0说明当前的队列符合条件 递归结束往上返回
        if (target == 0) {
            resList.add(new ArrayList<>(path));
            return;
        }
        //这里是剪枝操作 抛弃了接下来不符合的元素 如果target小于0就不可能会存在在满足的元素了 递归结束往上返回
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //这里是剪枝操作 抛弃了接下来不符合的元素 如果该元素大于target那么结束该层递归
            if (candidates[i] > target) {
                return;
            }
            //将元素装入到组合队列中
            path.add(candidates[i]);
            //递归判断
            dsf(candidates, target - candidates[i], i, path);
            //回溯删掉队列中末尾的元素
            path.removeLast();
        }

    }
}
