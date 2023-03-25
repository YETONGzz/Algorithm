package com.yetong.algorithm.Title100.Title50;

/**
 * 通配符匹配
 */
public class No43IsMatch {

    public static void main(String[] args) {

    }

    /**
     * 动态规划
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean isMatch(String str, String pattern) {


        int n = str.length(), m = pattern.length();
        // 技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始，而且可以使得 f[0][0] = true，可以将 true 这个结果滚动下去
        str = " " + str;
        pattern = " " + pattern;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        // f(i,j) 代表考虑 s 中的 1~i 字符和 p 中的 1~j 字符 是否匹配
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p[j] == '*') {
                    f[i][j] = f[i][j - 1] || (i - 1 >= 0 && f[i - 1][j]);
                } else {
                    f[i][j] = i - 1 >= 0 && f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '?');
                }
            }
        }

        return f[n][m];
    }
}
