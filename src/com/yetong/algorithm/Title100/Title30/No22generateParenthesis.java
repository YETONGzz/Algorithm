package com.yetong.algorithm.Title100.Title30;

import java.util.ArrayList;
import java.util.List;

public class No22generateParenthesis {
    public static void main(String[] args) {
        System.out.println(new No22generateParenthesis().generateParenthesis(3));
    }

    /*public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }



    */
    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     *//*
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            System.out.println(1);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }


        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }*/
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        dfs(new StringBuilder(), n, n);
        return res;
    }

    public void dfs(String str, int left, int right) {

        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(str + "(", left - 1, right);
        }

        if (right > 0) {
            dfs(str + ")", left, right - 1);
        }
    }

    private void dfs(StringBuilder path, int left, int right) {
        if (left == 0 && right == 0) {
            // path.toString() 生成了一个新的字符串，相当于做了一次拷贝，这里的做法等同于「力扣」第 46 题、第 39 题
            res.add(path.toString());
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            path.append("(");
            dfs(path, left - 1, right);
            path.deleteCharAt(path.length() - 1);
        }

        if (right > 0) {
            path.append(")");
            dfs(path, left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    /**
     * 括号生成
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        if (n == 0) {
            return res;
        }
        dfs(new StringBuilder(), n, n);
        return res;
    }

    /**
     * 回溯加剪枝
     * @param buffer
     * @param left
     * @param right
     */
    public void dfs(StringBuffer buffer, int left, int right) {
        if (right == 0 && left == 0) {
            res.add(buffer.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            buffer.append('(');
            dfs(buffer, left - 1, right);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        if (right > 0) {
            buffer.append(')');
            dfs(buffer, left, right - 1);
            buffer.deleteCharAt(buffer.length() - 1);
        }

    }


}
