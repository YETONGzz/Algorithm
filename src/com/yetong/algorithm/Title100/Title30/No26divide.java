package com.yetong.algorithm.Title100.Title30;

import sun.plugin2.os.windows.FLASHWINFO;

/**
 * 两数相除
 */
public class No26divide {
    public static void main(String[] args) {
        int divide = new No26divide().divideYouHua2(1004958205, -2137325331);
        System.out.println(divide);
        System.out.println(2147483647 /
                122481295);



    }


    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == -2147483648) {
                dividend += 1;
            }
            return 0 - dividend;
        }
        boolean flag = false;
        boolean flag2 = false;
        boolean flag3 = false;
        if (divisor > 0 && dividend < 0) {
            if (dividend == -2147483648) {
                flag3 = !flag3;
                if (divisor > 1) {
                    dividend += divisor;
                } else dividend += 1;
            }
            dividend = 0 - dividend;
            flag = !flag;
        } else if (divisor < 0 && dividend > 0) {
            if (divisor == -2147483648) {
                divisor += 1;
                divisor = 0 - divisor;
                if (divisor == dividend) {
                    return 0;
                }
            } else {
                divisor = 0 - divisor;
            }
            flag = !flag;
        } else if (divisor < 0 && dividend < 0) {
            if (dividend == -2147483648) {
                dividend += 1;
                flag2 = !flag2;
            }
            if (divisor == -2147483648) {
                divisor += 1;
            }
            dividend = 0 - dividend;
            divisor = 0 - divisor;
        }
        int res = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            res++;
        }
        if (flag) {
            res = 0 - res;
        }
        if (flag3) {
            res--;
        }
        return res;
    }

    public int divideYouHua(int a, int b) {
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;
        int LIMIT = -1073741824;
        if (a == MIN && b == -1) return MAX;
        boolean flag = false;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) flag = true;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int ans = 0;
        while (a <= b) {
            int c = b, d = -1;
            while (c >= LIMIT && d >= LIMIT && c >= a - c) {
                c += c;
                d += d;
            }
            a -= c;
            ans += d;
        }
        return flag ? ans : -ans;
    }

    public int divideYouHua2(int a, int b) {
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;
        if(b==-1&&a==MIN){
            return MIN;
        }
        if (b == -1) {
            return a;
        }
        if (b == 1) {
            return a;
        }
        boolean flag = false;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) flag = true;
        if (a > 0) a = 0 - a;
        if (b > 0) b = 0 - b;
        int temp = b;
        b = b * 2;
        int mul = 2;
        while (a - b < 0) {
            a -= b;
            mul += mul;
            b = b * 2;
        }
        mul-=2;
        int res = 0;
        while (a - temp <= 0) {
            a -= temp;
            res++;
        }
        return flag? 0-(res+mul): (res+mul);
    }


}
