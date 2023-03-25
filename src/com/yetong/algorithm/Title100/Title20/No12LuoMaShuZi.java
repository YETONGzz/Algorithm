package com.yetong.algorithm.Title100.Title20;

;

/**
 * 转换为罗马数字
 */
public class No12LuoMaShuZi {
    public static void main(String[] args) {
        System.out.println(intRoman(1530));
    }

    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


    public static String intRoman(int num) {
        int index = 0;
        StringBuffer buffer = new StringBuffer();
        while (index < 13) {
            if (num > values[index]) {
                buffer.append(symbols[index]);
                num -= values[index];
            } else {
                index++;
            }
        }
        return buffer.toString();
    }

}
