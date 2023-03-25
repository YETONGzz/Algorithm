package com.yetong.algorithm.Title100.Title20;

import java.util.HashMap;
import java.util.Map;

public class No13ZhengShuZhuanLuoMa {
    public static void main(String[] args) {
        test();
        System.out.println(numChangeRoman("MDXXX"));
        System.out.println(romanToIntYouHua("XX"));
        System.out.println(romanToInt("XX"));
    }

    public static int numChangeRoman(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        int res = 0;
        while (index < 13) {
            int length = symbols[index].length();
            if (length <= stringBuffer.length() && stringBuffer.substring(0, length).equals(symbols[index])) {
                res += values[index];
                stringBuffer.delete(0, length);
            } else {
                index++;
            }
        }
        return res;
    }

    public static int romanToIntYouHua(String str) {
        Map<Character, Integer> map = new HashMap() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int res = 0;
        int index = 0;
        int length = str.length();
        while (index < length-1) {
            Integer value = map.get(str.charAt(index));
            if (index < length - 1 && value >= map.get(str.charAt(index + 1))) {
                res += value;
            } else  {
                res -= value;
            }
            index++;
        }

        res += map.get(str.charAt(index));
        return res;
    }

    public static void test() {
        StringBuffer stringBuffer = new StringBuffer("s");
        System.out.println("=============" + stringBuffer.delete(0, 1).length());
    }

    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
