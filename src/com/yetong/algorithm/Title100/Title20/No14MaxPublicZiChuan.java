package com.yetong.algorithm.Title100.Title20;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No14MaxPublicZiChuan {
    public static void main(String[] args) {
        test();

        String[] s = {"a", "abc", "abcd"};
        System.out.println(longestCommonPrefix(s));
    }

    public static String youHua(String[] str) {
        if (str.length == 1) {
            return str[0];
        }
        String res = str[0];

        for (int i = 1; i < str.length; i++) {
            int j = 0;
            for (; j < res.length() && j < str[i].length(); j++) {
                if (res.charAt(j) != str[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
        }
        return res;
    }

    public static String longestCommonPrefix(String[] str) {
        if (str.length == 1) {
            return str[0];
        }
        int minLength = 222222222;
        int sum = 0;
        String res = "";
        try {
            for (int i = 1; i <= str.length; i++) {
                for (int j = 1; j < str.length; j++) {
                    if (str[0].substring(0, i).equals(str[j].substring(0, i))) {
                        sum++;
                    }
                }

                if (sum == str.length - 1) {
                    res = str[0].substring(0, i).length() > res.length() ? str[0].substring(0, i) : res;
                }
                sum = 0;
            }
        } catch (Exception e) {

        }

        return res;
    }

    public String maxYouHua(String[] str) {
        if (str.length < 2) {
            return str[0];
        }
        int n = str.length;
        String res = str[0];
        for (int i = 1; i < n; i++) {
            int j = 0;
            for (; j < str[i].length(); j++) {
                if (res.charAt(j) != str[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
        }
        return res;
    }

    public static void test() {
        String a = "sss";
    }
}
