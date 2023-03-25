package com.yetong.algorithm.Title100.Title40;

import java.util.*;

/**
 * 组合总和 II
 */
public class No39CombinationSumII {

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 1, 5, 6};
        No39CombinationSumII no39 = new No39CombinationSumII();
        System.out.println(no39.combinationSum2(arr, 8));
    }

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (null == candidates) {
            return null;
        }
        //对原数组进行排序是去除重复组合的关键
        Arrays.sort(candidates);
        //组合队列用来模拟栈方便进行回溯
        Deque<Integer> path = new ArrayDeque<>();
        //深度优先搜索  递归+回溯+剪枝
        this.dsf(candidates, 0, target, path);
        return res;
    }

    //深度优先搜索
    public void dsf(int[] candidates, int index, int target, Deque<Integer> path) {
        //如果target等于0说明当前队列符合那么装入res中
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        //循环递归
        for (int i = index; i < candidates.length; i++) {
            //大剪枝 如果目标值小于待选取元素那么舍弃剩下的元素 直接剪枝
            if (target < candidates[i]) {
                return;
            }
            /**
             * 小剪枝 防止出现 数组中的相同元素被重复选取与之前的组合重复
             * 当 i 大于 index时 说明第一个分支的递归结束了 进入了之后的分支进行递归
             * 如果此时 当前的数组中元素与他的前一个元素值相同 那么跳到下一层循环
             */
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            //递归
            dsf(candidates, i + 1, target - candidates[i], path);
            //回溯 去除不符合的元素
            path.removeLast();

        }
    }
}
