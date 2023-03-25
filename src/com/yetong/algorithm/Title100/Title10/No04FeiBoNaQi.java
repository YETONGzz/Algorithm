package com.yetong.algorithm.Title100.Title10;

/**
 * 斐波那契数列
 */
public class No04FeiBoNaQi {

    public static void main(String[] args) {
        No04FeiBoNaQi no04FeiBoNaQi = new No04FeiBoNaQi();
        System.out.println(no04FeiBoNaQi.dfs(10));
        System.out.println(no04FeiBoNaQi.dp(10));
    }

    public int dfs(int n) {
        if (n <= 2) {
            return 1;
        }
        return dfs(n - 1) + dfs(n - 2);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int dp(int n){
        if(n<=2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2;i < n;i++){
            a = b;
            b = c;
            c = a+b;
        }
        return c;
    }
}
