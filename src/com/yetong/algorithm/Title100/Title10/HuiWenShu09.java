package com.yetong.algorithm.Title100.Title10;


public class HuiWenShu09 {
    public static void main(String[] args) {
        System.out.println(isHuiWenShu(-121));
        System.out.println(isHuiWenShuYouHua(121));
    }

    public static boolean isHuiWenShu(int x) {
        StringBuffer stringBuffer = new StringBuffer(x + "");
        System.out.println(stringBuffer);
        if ((stringBuffer.reverse() + "").equals(x + "")) {
            return true;
        }
        return false;
    }

    public static boolean isHuiWenShuYouHua(int x) {
        int temp = x;
        if (x < 0) {
            return false;
        }
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (y == temp) {
            return true;
        }
        return false;
    }


}
