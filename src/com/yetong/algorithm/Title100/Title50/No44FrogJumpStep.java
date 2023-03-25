package com.yetong.algorithm.Title100.Title50;

/**
 * 青蛙跳阶
 */
public class No44FrogJumpStep {

    public static void main(String[] args) {
        No44FrogJumpStep no44 = new No44FrogJumpStep();
        System.out.println(no44.frogJumpStep(10));
        System.out.println(no44.frogJumpStepDp(10));
    }

    /**
     * 暴力递归
     *
     * @return 青蛙如果要跳到10层 那么必定会在9层跳一步上来 或者在8层跳二步上来
     * 那么要跳到9层 必定会在8层一步上来 或者在7层跳2步上来 那么以此类推
     * 最后青蛙如果要跳到1层 有一种跳法 跳到2层有两种跳法
     * 所以 n==1 返回 1 n==2返回 2
     */
    public int frogJumpStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return frogJumpStep(n - 1) + frogJumpStep(n - 2);
    }

    /**
     * 动态规划 动态规划的几大特征 重叠子问题 边界 状态转移方程 最优子结构
     * 重叠子问题就是  计算10层时要计算9层和8层 那么计算9层时又要计算8层和7层 此时8层就重复了被计算了两遍
     * 边界 就是n=1 n=2时
     * 状态转移方程就是 frog（n-1）+frog(n-2)
     * 最优子结构 frog(n-1) 和 frog(n-2) 就是 frog(n)的最优子结构
     *自底向上
     * @param n
     * @return
     */
    public int frogJumpStepDp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int res = 0;
        //底部子结构
        int a = 1;
        //底部子结构
        int b = 2;
        for (int i = 3; i <= n; i++) {
            //状态转移方程
            int temp = a + b;
            a = b;
            b = temp;
            res = temp;
        }
        return res;
    }

}
