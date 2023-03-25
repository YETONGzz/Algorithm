package com.yetong.algorithm.Title100.Title10;

/**
 * 数字翻转
 */
public class NumReverse07 {
    //解法一较慢
    public static int reverse(int x) {
        String s = "" + x;
        if (s.length() == 1) {
            return x;
        }
        StringBuffer str = new StringBuffer(s);
        String head = "";
        if (str.charAt(0) == 45) {
            head += str.substring(0, 1);
            str.delete(0, 1);
        }
        int length = str.length();
        for (int i = length - 1; length > 0; i--) {
            if (i == str.length() - 1 && str.substring(i, i + 1).equals("0")) {
                str.delete(i, i + 1);
            } else {
                break;
            }
        }
        StringBuffer res = new StringBuffer();
        res.append(head);
        str.reverse();
        res.append(str);
        int i = 0;
        try {
            i = Integer.parseInt(res.toString());
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    //解法二急速
    public static int reverseYouHua(int x) {
        int y = 0;
        while (x != 0) {
            if (y > 214748364 || y < -214748364) {
                return 0;
            }
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverseYouHua(123));
    }

}
