package com.yetong.algorithm.Title100.Title30;

import java.util.*;

/**
 * 最长有效括号
 */
public class No28longestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new No28longestValidParentheses().longestValidParentheses("()()()"));
    }

    public int longestValidParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        LinkedList<Character> list = new LinkedList<>();
        list.add('1');
        int res = 0;
        int[] arr = new int[s.length()];
        int[] arr2 = new int[s.length()];
        int m = 0;
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(s.charAt(i))) {
                list.add(c);
                arr2[m++] = i;
            } else {
                if (list.getLast() != '1') {
                    if (map.containsKey(list.removeLast())) {
                        arr[x] = arr2[x];
                        arr[++x] = i;
                        x++;
                    }
                } else {
                    res = 0;
                    continue;
                }
            }
        }
        Arrays.sort(arr);
        int t = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i + 1] - 1) {
                t++;
            }else {
                res = Math.max(t,res);
                t = 0;
            }
        }
        return res;
    }


}
